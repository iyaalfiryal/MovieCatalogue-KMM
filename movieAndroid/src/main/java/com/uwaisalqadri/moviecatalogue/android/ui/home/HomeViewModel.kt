package com.uwaisalqadri.moviecatalogue.android.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.usecase.home.GetBannerMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.home.GetPopularMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.home.GetUpComingMovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class HomeViewModel(
	private val popularUseCase: GetPopularMovieUseCase,
	private val upComingUseCase: GetUpComingMovieUseCase,
	private val bannerUseCase: GetBannerMovieUseCase
): ViewModel() {

	val popularMovie = MutableLiveData<List<Movie>>()
	val bannerMovie = MutableLiveData<List<Movie>>()
	val upComingMovie = MutableLiveData<List<Movie>>()

	val loading = MutableLiveData(true)

	init {
		requestBannerMovie()
		requestPopularMovie()
		requestUpComingMovie()
	}

	private fun requestPopularMovie() = viewModelScope.launch {
		popularUseCase.execute().collect {
			loading.value = false
			popularMovie.value = it.slice(0 until 10)
		}
	}

	private fun requestUpComingMovie() = viewModelScope.launch {
		upComingUseCase.execute().collect {
			loading.value = false
			upComingMovie.value = it.slice(0 until 10)
		}
	}

	private fun requestBannerMovie() = viewModelScope.launch {
		bannerUseCase.execute().collect {
			loading.value = false
			bannerMovie.value = it.slice(0 until 3)
		}
	}
}