package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 28, 2021
 */
@Serializable
data class GenreResponse(
	var genres: List<GenreItem> = emptyList()
)