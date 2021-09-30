package com.uwaisalqadri.moviecatalogue.domain.repository

import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.model.Video
import com.uwaisalqadri.moviecatalogue.utils.Constants
import kotlinx.coroutines.flow.Flow

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
interface MovieRepository {
	suspend fun getDiscoverMovies(year: Int, page: Int, sortBy: Constants.SortBy): Flow<List<Movie>>
	suspend fun getSearchMovies(query: String, page: Int): Flow<List<Movie>>
	suspend fun getDetailMovie(idMovie: Int): Flow<Movie>
	suspend fun getGenre(): Flow<List<Genre>>
	suspend fun getCast(idMovie: Int): Flow<List<Cast>>
	suspend fun getVideo(idMovie: Int): Flow<List<Video>>

	suspend fun getFavoriteMovies(query: String): Flow<List<Movie>?>
	suspend fun getFavoriteMovieById(idMovie: Int): Flow<List<Movie>?>
	suspend fun addFavoriteMovie(movie: Movie)
	suspend fun deleteFavoriteMovie(idMovie: Int)
}