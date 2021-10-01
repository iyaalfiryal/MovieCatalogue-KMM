package com.uwaisalqadri.moviecatalogue.android.ui.search

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.SearchListItemBinding
import com.uwaisalqadri.moviecatalogue.android.utils.loadImage
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.uwaisalqadri.moviecatalogue.utils.formatDate
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
class SearchItem(
	private val movie: Movie,
	private val onClick: (Movie) -> Unit
) : BindableItem<SearchListItemBinding>() {

	@RequiresApi(Build.VERSION_CODES.O)
	override fun bind(viewBinding: SearchListItemBinding, position: Int) {

		viewBinding.apply {
			movie.posterPath?.let { imgSearchItem.loadImage(Constants.urlImage + it) }
			tvCastMovie.text = movie.overview
			tvTitleMovie.text = movie.title
			tvGenreMovie.text = formatDate(movie.releaseDate ?: "", Constants.dateFormat)

			root.setOnClickListener {
				onClick(movie)
			}
		}
	}

	override fun getLayout(): Int = R.layout.search_list_item

	override fun initializeViewBinding(view: View): SearchListItemBinding {
		return SearchListItemBinding.bind(view)
	}
}
