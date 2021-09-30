package com.uwaisalqadri.moviecatalogue.domain.usecase.detail

import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
interface GetCastMovieUseCase {
	suspend fun execute(idMovie: Int): Flow<List<Cast>>
}

class GetCastMovieInteractor(
	private val repository: MovieRepository
): GetCastMovieUseCase {

	override suspend fun execute(idMovie: Int): Flow<List<Cast>> {
		return repository.getCast(idMovie)
	}

}