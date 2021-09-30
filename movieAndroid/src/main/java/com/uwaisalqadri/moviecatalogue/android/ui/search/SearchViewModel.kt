package com.uwaisalqadri.moviecatalogue.android.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.usecase.search.GetSearchMovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class SearchViewModel(
	private val searchUseCase: GetSearchMovieUseCase,
): ViewModel() {

	val searchMovie = MutableLiveData<List<Movie>>()

	val loading = MutableLiveData<Boolean>()
	val message = MutableLiveData<String>()

	fun requestSearchMovie(query: String) = viewModelScope.launch {
		loading.value = true
		searchUseCase.execute(query).collect {
			loading.value = false
			searchMovie.value = it
		}
	}
}