package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
@Serializable
data class VideoItem(
	var id: String? = "",
	var key: String? = "",
	var name: String? = "",
	var site: String? = "",
	var size: Int? = 0,
	var type: String? = ""
)
