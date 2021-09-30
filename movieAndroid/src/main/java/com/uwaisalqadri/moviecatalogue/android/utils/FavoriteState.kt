package com.uwaisalqadri.moviecatalogue.android.utils

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
sealed class FavoriteState {
	data class FavMovieDataFound(val state: Boolean) : FavoriteState()
	object AddFavorite : FavoriteState()
	object RemoveFavorite : FavoriteState()
}