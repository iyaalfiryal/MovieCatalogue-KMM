package com.uwaisalqadri.moviecatalogue.data.repository

import co.touchlab.kermit.Kermit
import com.uwaisalqadri.moviecatalogue.data.mapper.entity.MovieEntityMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.CastResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.GenreResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.MovieResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.VideoResponseMapper
import com.uwaisalqadri.moviecatalogue.data.source.local.MovieDatabaseWrapper
import com.uwaisalqadri.moviecatalogue.data.source.remote.RemoteDataSource
import com.uwaisalqadri.moviecatalogue.domain.model.Cast
import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.domain.model.Video
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import com.uwaisalqadri.moviecatalogue.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class MovieRepositoryImpl(
	private val remoteDataSource: RemoteDataSource,
	private val mapper: MovieResponseMapper,
	private val entityMapper: MovieEntityMapper,
	private val castMapper: CastResponseMapper,
	private val videoMapper: VideoResponseMapper,
	private val genreMapper: GenreResponseMapper
): MovieRepository, KoinComponent {

	private val logger: Kermit by inject()
	private val movieDatabaseWrapper: MovieDatabaseWrapper by inject()
	private val localDataSource = movieDatabaseWrapper.instance?.movieEntityQueries

	override suspend fun getDiscoverMovies(year: Int, page: Int, sortBy: Constants.SortBy): Flow<List<Movie>> {
		return flow {
			try {
				val response = remoteDataSource.getDiscoverMovies(year, page, sortBy).results.map { mapper.mapToDomain(it) }
				emit(response)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getSearchMovies(query: String, page: Int): Flow<List<Movie>> {
		return flow {
			try {
				val response = remoteDataSource.getSearchMovies(query, page).results.map { mapper.mapToDomain(it) }
				emit(response)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getDetailMovie(idMovie: Int): Flow<Movie> {
		return flow {
			try {
				val response = remoteDataSource.getDetailMovie(idMovie)
				emit(mapper.mapToDomain(response))
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getGenre(): Flow<List<Genre>> {
		return flow {
			try {
				val response = remoteDataSource.getGenre().genres.map { genreMapper.mapToDomain(it) }
				emit(response)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getCast(idMovie: Int): Flow<List<Cast>> {
		return flow {
			try {
				val response = remoteDataSource.getCast(idMovie).cast.map { castMapper.mapToDomain(it) }
				emit(response)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getVideo(idMovie: Int): Flow<List<Video>> {
		return flow {
			try {
				val response = remoteDataSource.getVideo(idMovie).results.map { videoMapper.mapToDomain(it) }
				emit(response)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getFavoriteMovies(query: String): Flow<List<Movie>?> {
		return flow {
			try {
				val result = (
				   if (query.isNotEmpty()) localDataSource?.selectByQuery(query)
				   else localDataSource?.selectAll()
				)?.executeAsList()?.map { entityMapper.mapToDomain(it) }

				emit(result)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun getFavoriteMovieById(idMovie: Int): Flow<List<Movie>?> {
		return flow {
			try {
				val result = localDataSource?.selectById(idMovie.toLong())?.executeAsList()?.map { entityMapper.mapToDomain(it) }
				emit(result)
			} catch (e: Throwable) {
				logger.d { e.toString() }
			}
		}
	}

	override suspend fun addFavoriteMovie(movie: Movie) {
		val item = entityMapper.mapToModel(movie)
		localDataSource?.insertItem(
			item.adult,
			item.backdropPath,
			item.genres,
			item.id,
			item.originalLanguage,
			item.originalTitle,
			item.overview,
			item.popularity,
			item.posterPath,
			item.releaseDate,
			item.title,
			item.video,
			item.voteAverage,
			item.voteCount
		)
	}

	override suspend fun deleteFavoriteMovie(idMovie: Int) {
		localDataSource?.deleteItem(idMovie.toLong())
	}

}











