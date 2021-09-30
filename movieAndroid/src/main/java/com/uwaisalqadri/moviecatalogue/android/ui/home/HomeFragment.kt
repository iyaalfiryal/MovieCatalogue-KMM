package com.uwaisalqadri.moviecatalogue.android.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.ActivityDetailBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.FragmentHomeBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.IncludeToolbarBinding
import com.uwaisalqadri.moviecatalogue.android.databinding.SliderIndicatorBinding
import com.uwaisalqadri.moviecatalogue.android.ui.detail.DetailActivity
import com.uwaisalqadri.moviecatalogue.android.utils.navigateToDetail
import com.uwaisalqadri.moviecatalogue.android.utils.showToast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class HomeFragment: Fragment(R.layout.fragment_home) {

	private val binding: FragmentHomeBinding by viewBinding()
	private val viewModel: HomeViewModel by viewModel()

	private lateinit var toolbarBinding: IncludeToolbarBinding
	private lateinit var sliderIndicator: SliderIndicatorBinding

	private val sliderAdapter = GroupAdapter<GroupieViewHolder>()
	private val popularAdapter = GroupAdapter<GroupieViewHolder>()
	private val upComingAdapter = GroupAdapter<GroupieViewHolder>()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		toolbarBinding = binding.toolbar
		sliderIndicator = binding.sliderIndicator

		with(viewModel) {
			bannerMovie.observe(viewLifecycleOwner) { movies ->
				movies.map {
					sliderAdapter.add(SliderMovieItem(it) { item ->
						navigateToDetail(requireContext(), item.id)
					})
				}
			}

			popularMovie.observe(viewLifecycleOwner) { movies ->
				movies.map {
					popularAdapter.add(MovieItem(it) { item ->
						navigateToDetail(requireContext(), item.id)
					})
				}
			}

			upComingMovie.observe(viewLifecycleOwner) { movies ->
				movies.map {
					upComingAdapter.add(MovieItem(it) { item ->
						navigateToDetail(requireContext(), item.id)
					})
				}
			}

			loading.observe(viewLifecycleOwner) {
				binding.progressCircular.isVisible = it
			}
		}

		with(binding.rvComingSoon) {
			val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
			layoutManager = linearLayoutManager
			adapter = upComingAdapter
			setHasFixedSize(true)
		}

		with(binding.rvPopularMovies) {
			val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
			layoutManager = linearLayoutManager
			adapter = popularAdapter
			setHasFixedSize(true)
		}

		with(binding.rvSlider) {
			val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
			layoutManager = linearLayoutManager
			adapter = sliderAdapter
			setHasFixedSize(true)

			val snapHelper = PagerSnapHelper()
			snapHelper.attachToRecyclerView(this)

			addOnScrollListener(object : RecyclerView.OnScrollListener() {

				override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
					super.onScrollStateChanged(recyclerView, newState)

					if (newState == RecyclerView.SCROLL_STATE_IDLE) {
						val item = snapHelper.findSnapView(linearLayoutManager)
						item?.let { linearLayoutManager.getPosition(it) }
					}
				}

				override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
					super.onScrolled(recyclerView, dx, dy)
					val position = linearLayoutManager.findFirstVisibleItemPosition()
					sliderIndicator.apply {
						item1.setImageResource(if (position == 0) R.drawable.current_slider_item else R.drawable.uncurrent_slider_item)
						item2.setImageResource(if (position == 1) R.drawable.current_slider_item else R.drawable.uncurrent_slider_item)
						item3.setImageResource(if (position == 2) R.drawable.current_slider_item else R.drawable.uncurrent_slider_item)
					}
				}
			})
		}

		toolbarBinding.apply {
			inputSearch.isVisible = false
			logo.isVisible = true
			btnSearch.setImageResource(R.drawable.ic_notification)
		}
	}
}









