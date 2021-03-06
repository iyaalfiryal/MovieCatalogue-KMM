package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
@Serializable
data class CastItem(
	val adult: Boolean? = false,
	val cast_id: Int? = 0,
	val character: String? = "",
	val credit_id: String? = "",
	val gender: Int? = 0,
	val id: Int? = 0,
	val known_for_department: String? = "",
	val name: String? = "",
	val order: Int? = 0,
	val original_name: String? = "",
	val popularity: Double? = 0.0,
	val profile_path: String? = ""
)
