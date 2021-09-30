package com.uwaisalqadri.moviecatalogue.data.mapper.response

import com.uwaisalqadri.moviecatalogue.data.mapper.BaseMapper
import com.uwaisalqadri.moviecatalogue.data.source.remote.response.CastItem
import com.uwaisalqadri.moviecatalogue.domain.model.Cast

/**
 * Created by Uwais Alqadri on September 25, 2021
 */
class CastResponseMapper : BaseMapper<CastItem, Cast> {
	override fun mapToDomain(model: CastItem): Cast {
		return Cast(
			model.adult,
			model.cast_id,
			model.character,
			model.credit_id,
			model.gender,
			model.id,
			model.known_for_department,
			model.name,
			model.order,
			model.original_name,
			model.popularity,
			model.profile_path
		)
	}

	override fun mapToModel(domain: Cast): CastItem {
		return CastItem(
			domain.adult,
			domain.castId,
			domain.character,
			domain.creditId,
			domain.gender,
			domain.id,
			domain.knownForDepartment,
			domain.name,
			domain.order,
			domain.originalName,
			domain.popularity,
			domain.profilePath
		)
	}
}