package com.uwaisalqadri.moviecatalogue.android.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.moviecatalogue.android.utils.FavoriteState
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.usecase.favorite.GetFavoriteMovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class FavoriteViewModel(
	private val favoriteUseCase: GetFavoriteMovieUseCase
): ViewModel() {

	val favoriteMovie = MutableLiveData<List<Movie>>()
	val favoriteState = MutableLiveData<FavoriteState>()

	fun requestFavoriteMovie(query: String) = viewModelScope.launch {
		favoriteUseCase.get(query).collect {
			favoriteMovie.value = it
		}
	}

	fun checkFavoriteMovie(idMovie: Int) = viewModelScope.launch {
		favoriteUseCase.getById(idMovie).collect { movies ->
			movies?.map {
				favoriteState.value = FavoriteState.FavMovieDataFound(it.id == idMovie)
			}
		}
	}

	fun addFavoriteMovie(movie: Movie) = viewModelScope.launch {
		favoriteUseCase.add(movie)
		favoriteState.value = FavoriteState.AddFavorite
	}

	fun deleteFavoriteMovie(idMovie: Int) = viewModelScope.launch {
		favoriteUseCase.delete(idMovie)
		favoriteState.value = FavoriteState.RemoveFavorite
	}
}