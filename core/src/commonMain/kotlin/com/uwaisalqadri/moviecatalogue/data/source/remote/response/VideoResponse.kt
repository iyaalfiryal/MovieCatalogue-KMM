package com.uwaisalqadri.moviecatalogue.data.source.remote.response

import kotlinx.serialization.Serializable

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
@Serializable
data class VideoResponse(
	var id: Int? = 0,
	var results: List<VideoItem> = emptyList()
)