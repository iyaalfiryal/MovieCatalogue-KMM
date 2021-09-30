package com.uwaisalqadri.moviecatalogue.data.mapper.entity

import com.uwaisalqadri.moviecatalogue.data.mapper.BaseMapper
import com.uwaisalqadri.moviecatalogue.domain.model.Movie
import com.uwaisalqadri.moviecatalogue.utils.Extensions
import comuwaisalqadrimoviecatalogue.db.MovieEntity

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
class MovieEntityMapper: BaseMapper<MovieEntity, Movie> {
	override fun mapToDomain(model: MovieEntity): Movie {
		return Movie(
			model.adult,
			model.backdropPath,
			emptyList(),
			emptyList(),
			model.genres,
			model.id,
			model.originalLanguage,
			model.originalTitle,
			model.overview,
			model.popularity,
			model.posterPath,
			model.releaseDate,
			model.title,
			model.video,
			model.voteAverage,
			model.voteCount?.toInt()
		)
	}

	override fun mapToModel(domain: Movie): MovieEntity {
		val extension = Extensions
		return MovieEntity(
			domain.adult,
			domain.backdropPath,
			extension.genreNames(domain.genres),
			domain.id ?: 0,
			domain.originalLanguage,
			domain.originalTitle ?: "",
			domain.overview,
			domain.popularity,
			domain.posterPath,
			domain.releaseDate ?: "",
			domain.title,
			domain.video,
			domain.voteAverage,
			(domain.voteCount ?: 0).toLong()
		)
	}
}