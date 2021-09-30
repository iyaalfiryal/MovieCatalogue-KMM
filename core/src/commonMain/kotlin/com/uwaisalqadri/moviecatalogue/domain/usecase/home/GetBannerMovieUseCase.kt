package com.uwaisalqadri.moviecatalogue.domain.usecase.home

import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import com.uwaisalqadri.moviecatalogue.utils.Constants
import com.uwaisalqadri.moviecatalogue.utils.Extensions
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */

// argument's default value doesn't work in swift
interface GetBannerMovieUseCase {

	suspend fun execute(
		year: Int = Extensions.currentYear,
		page: Int = 1,
		sortBy: Constants.SortBy = Constants.SortBy.Release
	): Flow<List<Movie>>

}

class GetBannerMovieInteractor(
	private val repository: MovieRepository
): GetBannerMovieUseCase {

	override suspend fun execute(year: Int, page: Int, sortBy: Constants.SortBy): Flow<List<Movie>> {
		return repository.getDiscoverMovies(year, page, sortBy)
	}

}