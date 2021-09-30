package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
@Serializable
data class MovieItem(
	var adult: Boolean? = false,
	var backdrop_path: String? = "",
	var genres: List<GenreItem> = emptyList(),
	var genre_ids: List<Int>? = null,
	var id: Int? = 0,
	var original_language: String? = "",
	var original_title: String? = "",
	var overview: String? = "",
	var popularity: Double? = 0.0,
	var poster_path: String? = "",
	var release_date: String? = "",
	var title: String? = "",
	var video: Boolean? = false,
	var vote_average: Double? = 0.0,
	var vote_count: Int? = 0
)
