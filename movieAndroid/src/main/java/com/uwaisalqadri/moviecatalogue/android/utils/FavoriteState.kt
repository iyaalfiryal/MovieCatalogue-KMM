package com.uwaisalqadri.moviecatalogue.android.utils

import com.uwaisalqadri.moviecatalogue.domain.model.Movie

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
sealed class FavoriteState
data class FavMovieDataFound(val movie: List<Movie>) : FavoriteState()
object AddFavorite : FavoriteState()
object RemoveFavorite : FavoriteState()