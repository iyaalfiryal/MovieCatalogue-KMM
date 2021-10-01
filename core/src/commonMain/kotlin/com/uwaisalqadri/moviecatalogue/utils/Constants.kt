package com.uwaisalqadri.moviecatalogue.utils

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
object Constants {
	const val baseUrl = "https://api.themoviedb.org/3"
	const val apiKey = "270363a57bb9637a16bdd04f9979e433"
	const val lang = "en-US"

	const val urlImage = "https://image.tmdb.org/t/p/original"
	const val youtubeUrl = "https://www.youtube.com/watch?v="
	const val dateFormat = "dd MMM, yyyy"
	const val formatFromApi = "yyyy-MM-dd"

	enum class SortBy(val sort: String) {
		Popularity("popularity.desc"),
		Release("release.desc"),
		Vote("vote_average.asc")
	}
}