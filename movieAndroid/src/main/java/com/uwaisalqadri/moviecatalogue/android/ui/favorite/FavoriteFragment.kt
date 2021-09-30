package com.uwaisalqadri.moviecatalogue.android.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.FragmentFavoriteBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.IncludeToolbarBinding
import com.uwaisalqadri.moviecatalogue.android.utils.navigateToDetail
import com.uwaisalqadri.moviecatalogue.android.utils.snackBar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

	private val binding: FragmentFavoriteBinding by viewBinding()
	private val viewModel: FavoriteViewModel by viewModel()
	private val favoriteAdapter = GroupAdapter<GroupieViewHolder>()

	private lateinit var toolbarBinding: IncludeToolbarBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		toolbarBinding = binding.toolbar

		var job: Job? = null
		toolbarBinding.apply {
			inputSearch.addTextChangedListener { editable ->
				job?.cancel()
				job = MainScope().launch {
					delay(200L)
					editable?.let {
						favoriteAdapter.clear()
						if (it.isNotEmpty()) {
							viewModel.requestFavoriteMovie(it.toString())
						}
					}
				}
			}

			btnSearch.setOnClickListener {
				val query = inputSearch.text.toString()
				viewModel.requestFavoriteMovie(query)
			}
		}

		with(viewModel) {
			viewModel.requestFavoriteMovie("")
			favoriteMovie.observe(viewLifecycleOwner) { favorites ->

				favorites.forEach { movies ->
					favoriteAdapter.add(FavoriteItem(movies,
						onRemove = {
							binding.root.snackBar("${it.title} Removed!")
							deleteFavoriteMovie(it.id ?: 0)
							reloadData()
						},
						onClick = {
							navigateToDetail(requireContext(), it.id)
						}
					))
				}

			}
		}

		with(binding.rvFavorites) {
			adapter = favoriteAdapter
			layoutManager = LinearLayoutManager(context)
		}
	}

	override fun onResume() {
		super.onResume()
		reloadData()
	}

	private fun reloadData() {
		favoriteAdapter.clear()
		favoriteAdapter.notifyDataSetChanged()
		viewModel.requestFavoriteMovie("")
	}
}