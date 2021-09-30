package com.uwaisalqadri.moviecatalogue.domain.usecase.detail

import com.uwaisalqadri.moviecatalogue.domain.model.Video
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
interface GetVideoMovieUseCase {
	suspend fun execute(idMovie: Int): Flow<List<Video>>
}

class GetVideoMovieInteractor(
	private val repository: MovieRepository
): GetVideoMovieUseCase {

	override suspend fun execute(idMovie: Int): Flow<List<Video>> {
		return repository.getVideo(idMovie)
	}

}