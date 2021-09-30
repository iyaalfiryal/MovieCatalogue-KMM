package com.uwaisalqadri.moviecatalogue.android.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.moviecatalogue.android.utils.AddFavorite
import com.uwaisalqadri.moviecatalogue.android.utils.FavMovieDataFound
import com.uwaisalqadri.moviecatalogue.android.utils.FavoriteState
import com.uwaisalqadri.moviecatalogue.android.utils.RemoveFavorite
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.model.Video
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetCastMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetDetailMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.favorite.GetFavoriteMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetVideoMovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class DetailViewModel(
	private val detailUseCase: GetDetailMovieUseCase,
	private val castUseCase: GetCastMovieUseCase,
	private val videoUseCase: GetVideoMovieUseCase,
	private val favoriteUseCase: GetFavoriteMovieUseCase
): ViewModel() {

	val detailMovie = MutableLiveData<Movie>()
	val castMovie = MutableLiveData<List<Cast>>()
	val videoMovie = MutableLiveData<List<Video>>()

	val favoriteState = MutableLiveData<FavoriteState>()

	val loading = MutableLiveData(true)

	fun requestDetailMovie(idMovie: Int) = viewModelScope.launch {
		detailUseCase.execute(idMovie).collect {
			loading.value = false
			detailMovie.value = it
		}
	}

	fun requestCastMovie(idMovie: Int) = viewModelScope.launch {
		castUseCase.execute(idMovie).collect {
			loading.value = false
			castMovie.value = it
		}
	}

	fun requestVideoMovie(idMovie: Int) = viewModelScope.launch {
		videoUseCase.execute(idMovie).collect {
			loading.value = false
			videoMovie.value = it
		}
	}

	fun checkFavoriteMovie(idMovie: Int) = viewModelScope.launch {
		favoriteUseCase.getById(idMovie).collect {
			favoriteState.value = FavMovieDataFound(it ?: emptyList())
		}
	}

	fun addFavoriteMovie(movie: Movie) = viewModelScope.launch {
		favoriteUseCase.add(movie)
		favoriteState.value = AddFavorite
	}

	fun deleteFavoriteMovie(idMovie: Int) = viewModelScope.launch {
		favoriteUseCase.delete(idMovie)
		favoriteState.value = RemoveFavorite
	}
}








