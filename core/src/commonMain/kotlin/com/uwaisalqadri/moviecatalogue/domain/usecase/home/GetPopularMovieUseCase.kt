package com.uwaisalqadri.moviecatalogue.domain.usecase.home

import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.uwaisalqadri.moviecatalogue.utils.Extensions
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */

interface GetPopularMovieUseCase {

	suspend fun execute(
		year: Int = Extensions.currentYear,
		page: Int = 1,
		sortBy: Constants.SortBy = Constants.SortBy.Popularity
	): Flow<List<Movie>>

}

class GetPopularMovieInteractor(
	private val repository: MovieRepository
): GetPopularMovieUseCase {

	override suspend fun execute(year: Int, page: Int, sortBy: Constants.SortBy): Flow<List<Movie>> {
		return repository.getDiscoverMovies(year, page, sortBy)
	}

}