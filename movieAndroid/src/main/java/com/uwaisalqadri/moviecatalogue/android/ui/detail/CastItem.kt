package com.uwaisalqadri.moviecatalogue.android.ui.detail

import android.view.View
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.databinding.CastListItemBinding
import com.uwaisalqadri.moviecatalogue.android.utils.loadImage
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.xwray.groupie.viewbinding.BindableItem

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
class CastItem(
	private val cast: Cast
) : BindableItem<CastListItemBinding>() {

	override fun bind(viewBinding: CastListItemBinding, position: Int) {
		viewBinding.apply {
			cast.profilePath.let { imgCast.loadImage(Constants.urlImage + it) }
			nameCast.text = cast.name
		}
	}

	override fun getLayout(): Int = R.layout.cast_list_item

	override fun initializeViewBinding(view: View): CastListItemBinding = CastListItemBinding.bind(view)
}