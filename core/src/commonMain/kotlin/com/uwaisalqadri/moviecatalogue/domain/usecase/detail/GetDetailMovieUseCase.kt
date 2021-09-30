package com.uwaisalqadri.moviecatalogue.domain.usecase.detail

import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
interface GetDetailMovieUseCase {
	suspend fun execute(idMovie: Int): Flow<Movie>
}

class GetDetailMovieInteractor(
	private val repository: MovieRepository
): GetDetailMovieUseCase {

	override suspend fun execute(idMovie: Int): Flow<Movie> {
		return repository.getDetailMovie(idMovie)
	}

}