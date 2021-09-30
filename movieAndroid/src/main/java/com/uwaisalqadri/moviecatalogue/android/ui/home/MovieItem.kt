package com.uwaisalqadri.moviecatalogue.android.ui.home

import android.view.View
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.HomeListItemBinding
import com.uwaisalqadri.moviecatalogue.android.utils.loadImage
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
class MovieItem(
	private val movie: Movie,
	private val onItemClick: (Movie) -> Unit
) : BindableItem<HomeListItemBinding>() {

	override fun bind(viewBinding: HomeListItemBinding, position: Int) {
		viewBinding.apply {
			movie.posterPath?.let { imgHomeItem.loadImage(Constants.urlImage + it) }

			root.setOnClickListener {
				onItemClick(movie)
			}
		}
	}

	override fun getLayout(): Int = R.layout.home_list_item

	override fun initializeViewBinding(view: View): HomeListItemBinding =
		HomeListItemBinding.bind(view)
}