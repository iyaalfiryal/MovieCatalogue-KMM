package com.uwaisalqadri.moviecatalogue.utils

import com.uwaisalqadri.moviecatalogue.domain.model.Genre
import kotlinx.datetime.*

/**
 * Created by Uwais Alqadri on September 24, 2021
 */

// extension function doesn't work in swift
object Extensions {
	val currentYear = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
	val nextYear = currentYear + 1

	fun genreNames(genres: List<Genre>): String {
		val genreNames = mutableListOf<String>()
		genres.forEach { genreNames.add(it.name ?: "") }

		return genreNames.joinToString(", ")
	}

//	fun formatDate(dateString: String) {
//		Date()
//	}
}