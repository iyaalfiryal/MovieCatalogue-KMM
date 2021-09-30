package com.uwaisalqadri.moviecatalogue.android.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.ActivityDetailBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.FragmentSearchBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.IncludeToolbarBinding
import com.uwaisalqadri.moviecatalogue.android.ui.detail.DetailActivity
import com.uwaisalqadri.moviecatalogue.android.utils.navigateToDetail
import com.uwaisalqadri.moviecatalogue.android.utils.showToast
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class SearchFragment: Fragment(R.layout.fragment_search) {

	private val binding: FragmentSearchBinding by viewBinding()
	private val viewModel: SearchViewModel by viewModel()
	private val searchAdapter = GroupAdapter<GroupieViewHolder>()

	private lateinit var toolbarBinding: IncludeToolbarBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		toolbarBinding = binding.toolbar

		var job: Job? = null
		toolbarBinding.apply {
			inputSearch.addTextChangedListener { editable ->
				job?.cancel()
				job = MainScope().launch {
					delay(500L)
					editable?.let {
						searchAdapter.clear()
						if (it.isNotEmpty()) {
							viewModel.requestSearchMovie(it.toString())
							binding.apply {
								tvSearchedItem.text = "'$it'"
								description.isVisible = true
							}
						} else {
							binding.apply {
								tvSearchedItem.text = ""
								description.isVisible = false
							}
						}
					}
				}
			}

			btnSearch.setOnClickListener {
				val query = inputSearch.text.toString()
				viewModel.requestSearchMovie(query)
			}
		}

		with(viewModel) {
			searchMovie.observe(viewLifecycleOwner) { movies ->
				movies.forEach { movie ->
					searchAdapter.add(
						SearchItem(movie) {
							navigateToDetail(requireContext(), it.id)
						}
					)
				}
			}

			message.observe(viewLifecycleOwner) {
				context?.showToast(it)
			}

			loading.observe(viewLifecycleOwner) {
				binding.progressCircular.isVisible = it
			}
		}

		with(binding.rvSearchResult) {
			adapter = searchAdapter
			layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
		}
	}
}