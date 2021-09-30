package com.uwaisalqadri.moviecatalogue.data.mapper.response

import com.uwaisalqadri.moviecatalogue.data.mapper.BaseMapper
import com.uwaisalqadri.moviecatalogue.data.source.remote.response.GenreItem
import com.uwaisalqadri.moviecatalogue.domain.model.Genre

/**
 * Created by Uwais Alqadri on September 26, 2021
 */
class GenreResponseMapper: BaseMapper<GenreItem, Genre> {
	override fun mapToDomain(model: GenreItem): Genre {
		return Genre(model.id, model.name)
	}

	override fun mapToModel(domain: Genre): GenreItem {
		return GenreItem(domain.id, domain.name)
	}
}