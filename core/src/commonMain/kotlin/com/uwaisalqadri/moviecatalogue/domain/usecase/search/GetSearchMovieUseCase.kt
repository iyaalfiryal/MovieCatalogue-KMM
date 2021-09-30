package com.uwaisalqadri.moviecatalogue.domain.usecase.search

import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */

interface GetSearchMovieUseCase {
	suspend fun execute(query: String, page: Int = 1): Flow<List<Movie>>
}

class GetSearchMovieInteractor(
	private val repository: MovieRepository
): GetSearchMovieUseCase {

	override suspend fun execute(query: String, page: Int): Flow<List<Movie>> {
		return repository.getSearchMovies(query, page)
	}

}