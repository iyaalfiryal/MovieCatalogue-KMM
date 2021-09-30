package com.uwaisalqadri.moviecatalogue.domain.model

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
data class Cast(
	val adult: Boolean?,
	val castId: Int?,
	val character: String?,
	val creditId: String?,
	val gender: Int?,
	val id: Int?,
	val knownForDepartment: String?,
	val name: String?,
	val order: Int?,
	val originalName: String?,
	val popularity: Double?,
	val profilePath: String?
)