package com.uwaisalqadri.moviecatalogue.domain.model

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
data class Movie (
	val adult: Boolean?,
	val backdropPath: String?,
	val genres: List<Genre>,
	val genreIds: List<Int>?,
	val genreNames: String?,
	val id: Int?,
	val originalLanguage: String?,
	val originalTitle: String?,
	val overview: String?,
	val popularity: Double?,
	val posterPath: String?,
	val releaseDate: String?,
	val title: String?,
	val video: Boolean?,
	val voteAverage: Double?,
	val voteCount: Int?
)
