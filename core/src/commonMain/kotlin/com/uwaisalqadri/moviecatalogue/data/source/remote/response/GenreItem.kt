package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
@Serializable
data class GenreItem(
	val id: Int? = 0,
	val name: String? = ""
)