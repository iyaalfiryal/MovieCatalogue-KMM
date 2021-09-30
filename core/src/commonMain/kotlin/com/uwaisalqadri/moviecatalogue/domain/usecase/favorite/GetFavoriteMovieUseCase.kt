package com.uwaisalqadri.moviecatalogue.domain.usecase.favorite

import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
interface GetFavoriteMovieUseCase {
	suspend fun get(query: String): Flow<List<Movie>?>
	suspend fun getById(idMovie: Int): Flow<List<Movie>?>
	suspend fun add(movie: Movie)
	suspend fun delete(idMovie: Int)
}

class GetFavoriteMovieInteractor(
	private val repository: MovieRepository
): GetFavoriteMovieUseCase {
	override suspend fun get(query: String): Flow<List<Movie>?> {
		return repository.getFavoriteMovies(query)
	}

	override suspend fun getById(idMovie: Int): Flow<List<Movie>?> {
		return repository.getFavoriteMovieById(idMovie)
	}

	override suspend fun add(movie: Movie) {
		repository.addFavoriteMovie(movie)
	}

	override suspend fun delete(idMovie: Int) {
		repository.deleteFavoriteMovie(idMovie)
	}
}










