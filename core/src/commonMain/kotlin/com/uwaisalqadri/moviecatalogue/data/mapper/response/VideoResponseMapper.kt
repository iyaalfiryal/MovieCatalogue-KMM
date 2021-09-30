package com.uwaisalqadri.moviecatalogue.data.mapper.response

import com.uwaisalqadri.moviecatalogue.data.mapper.BaseMapper
import com.uwaisalqadri.moviecatalogue.data.source.remote.response.VideoItem
import com.uwaisalqadri.moviecatalogue.domain.model.Video

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
class VideoResponseMapper : BaseMapper<VideoItem, Video> {
	override fun mapToDomain(model: VideoItem): Video {
		return Video(
			model.id,
			model.key,
			model.name,
			model.site,
			model.size,
			model.type
		)
	}

	override fun mapToModel(domain: Video): VideoItem {
		return VideoItem(
			domain.id,
			domain.key,
			domain.name,
			domain.site,
			domain.size,
			domain.type
		)
	}
}
