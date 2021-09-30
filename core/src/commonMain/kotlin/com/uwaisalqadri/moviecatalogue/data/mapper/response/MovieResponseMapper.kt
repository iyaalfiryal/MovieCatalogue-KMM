package com.uwaisalqadri.moviecatalogue.data.mapper.response

import com.uwaisalqadri.moviecatalogue.data.mapper.BaseMapper
import com.uwaisalqadri.moviecatalogue.data.source.remote.response.MovieItem
import com.uwaisalqadri.moviecatalogue.domain.model.Movie

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class MovieResponseMapper(
	private val genreMapper: GenreResponseMapper
) : BaseMapper<MovieItem, Movie> {
	override fun mapToDomain(model: MovieItem): Movie {
		return Movie(
			model.adult,
			model.backdrop_path,
			genreMapper.mapToListDomain(model.genres),
			model.genre_ids,
			"",
			model.id,
			model.original_language,
			model.original_title,
			model.overview,
			model.popularity,
			model.poster_path,
			model.release_date,
			model.title,
			model.video,
			model.vote_average,
			model.vote_count
		)

	}

	override fun mapToModel(domain: Movie): MovieItem {
		return MovieItem(
			domain.adult,
			domain.backdropPath,
			genreMapper.mapToListModel(domain.genres),
			domain.genreIds,
			domain.id,
			domain.originalLanguage,
			domain.originalTitle,
			domain.overview,
			domain.popularity,
			domain.posterPath,
			domain.releaseDate,
			domain.title,
			domain.video,
			domain.voteAverage,
			domain.voteCount
		)
	}

}