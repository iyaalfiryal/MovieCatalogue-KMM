package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
@Serializable
data class MovieResponse(
	var results: List<MovieItem> = emptyList()
)