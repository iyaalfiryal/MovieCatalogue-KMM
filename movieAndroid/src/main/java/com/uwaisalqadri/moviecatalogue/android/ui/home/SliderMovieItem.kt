package com.uwaisalqadri.moviecatalogue.android.ui.home

import android.view.View
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.SliderHomeItemBinding
import com.uwaisalqadri.moviecatalogue.android.utils.loadImage
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on September 25, 2021
 */

class SliderMovieItem(
	private val movie: Movie,
	private val onClick: (Movie) -> Unit
) : BindableItem<SliderHomeItemBinding>() {

	override fun bind(viewBinding: SliderHomeItemBinding, position: Int) {
		viewBinding.apply {
			imgSliderHomeItem.loadImage(Constants.urlImage + movie.backdropPath)

			root.setOnClickListener {
				onClick(movie)
			}
		}
	}

	override fun getLayout(): Int = R.layout.slider_home_item

	override fun initializeViewBinding(view: View): SliderHomeItemBinding =
		SliderHomeItemBinding.bind(view)
}