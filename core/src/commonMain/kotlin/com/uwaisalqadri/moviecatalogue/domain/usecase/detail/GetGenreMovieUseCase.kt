package com.uwaisalqadri.moviecatalogue.domain.usecase.detail

import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
interface GetGenreMovieUseCase {
	suspend fun execute(): Flow<List<Genre>>
}

class GetGenreMovieInteractor(
	private val repository: MovieRepository
): GetGenreMovieUseCase {

	override suspend fun execute(): Flow<List<Genre>> {
		return repository.getGenre()
	}

}