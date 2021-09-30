package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
@Serializable
data class CastResponse(
	var cast: List<CastItem> = emptyList(),
	var id: Int? = 0
)