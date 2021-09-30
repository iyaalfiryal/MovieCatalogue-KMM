package com.uwaisalqadri.moviecatalogue.android.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.uwaisalqadri.moviecatalogue.android.R
import com.uwaisalqadri.moviecatalogue.android.ui.detail.DetailActivity

/**
 * Created by Uwais Alqadri on September 24, 2021
 */

fun Context.showToast(msg: String) {

	Toast.makeText(
		this,
		msg,
		Toast.LENGTH_SHORT
	).show()

}

fun View.snackBar(msg: String) {

	Snackbar.make(
		this,
		msg,
		Snackbar.LENGTH_SHORT
	).show()

}

fun Fragment.navigateToDetail(context: Context, idMovie: Int?) {
	startActivity(
		Intent(context, DetailActivity::class.java)
			.putExtra(DetailActivity.EXTRA_MOVIE, idMovie)
	)
}

fun ImageView.loadImage(url: String) {

	Glide.with(this)
		.load(url)
		.placeholder(R.drawable.placeholder_image)
		.fallback(R.drawable.placeholder_image)
		.into(this)

}

fun Context.openLink(url: String) {
	val openLink = Intent(Intent.ACTION_VIEW)
	openLink.data = Uri.parse(url)
	startActivity(openLink)
}