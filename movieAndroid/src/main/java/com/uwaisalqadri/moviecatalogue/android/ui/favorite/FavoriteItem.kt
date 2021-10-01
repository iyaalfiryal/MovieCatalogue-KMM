package com.uwaisalqadri.moviecatalogue.android.ui.favorite

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.FavoriteListItemBinding
import com.uwaisalqadri.moviecatalogue.android.utils.loadImage
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.uwaisalqadri.moviecatalogue.utils.formatDate
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
class FavoriteItem(
	private val movie: Movie,
	private val onRemove: (Movie) -> Unit,
	private val onClick: (Movie) -> Unit
): BindableItem<FavoriteListItemBinding>() {

	@RequiresApi(Build.VERSION_CODES.O)
	override fun bind(viewBinding: FavoriteListItemBinding, position: Int) {
		viewBinding.apply {
			favMovieImg.loadImage(Constants.urlImage + movie.backdropPath)
			favMovieGenres.text = movie.genreNames
			favMovieReleased.text = formatDate(movie.releaseDate ?: "", "yyyy")
			favMovieTitle.text = movie.title
			btnFavorite.setOnClickListener { onRemove(movie) }

			root.setOnClickListener { onClick(movie) }
		}
	}

	override fun getLayout(): Int = R.layout.favorite_list_item

	override fun initializeViewBinding(view: View): FavoriteListItemBinding {
		return FavoriteListItemBinding.bind(view)
	}
}