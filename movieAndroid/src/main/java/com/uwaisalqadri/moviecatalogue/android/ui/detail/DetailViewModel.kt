package com.uwaisalqadri.moviecatalogue.android.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.model.Video
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetCastMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetDetailMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.GetVideoMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.favorite.GetFavoriteMovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class DetailViewModel(
	private val detailUseCase: GetDetailMovieUseCase,
	private val castUseCase: GetCastMovieUseCase,
	private val videoUseCase: GetVideoMovieUseCase,
): ViewModel() {

	val detailMovie = MutableLiveData<Movie>()
	val castMovie = MutableLiveData<List<Cast>>()
	val videoMovie = MutableLiveData<List<Video>>()

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
}








