package com.uwaisalqadri.moviecatalogue.data.source.remote

import com.uwaisalqadri.moviecatalogue.data.source.remote.response.*
import com.uwaisalqadri.moviecatalogue.utils.Constants
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class RemoteDataSource(
	private val ktor: HttpClient
) {

	suspend fun getDiscoverMovies(year: Int, page: Int, sortBy: Constants.SortBy) =
		ktor.get<MovieResponse>(
			"${Constants.baseUrl}/discover/movie?api_key=${Constants.apiKey}&language${Constants.lang}&sort_by=${sortBy.sort}&include_video=true&page=$page&year=$year"
		)

	suspend fun getSearchMovies(query: String, page: Int) =
		ktor.get<MovieResponse>(
			"${Constants.baseUrl}/search/movie?api_key=${Constants.apiKey}&language=${Constants.lang}&query=$query&page=$page"
		)

	suspend fun getDetailMovie(idMovie: Int) =
		ktor.get<MovieItem>(
			"${Constants.baseUrl}/movie/$idMovie?api_key=${Constants.apiKey}&language=${Constants.lang}"
		)

	suspend fun getGenre() =
		ktor.get<GenreResponse>(
			"${Constants.baseUrl}/genre/movie/list?api_key=${Constants.apiKey}&language=${Constants.lang}"
		)

	suspend fun getCast(idMovie: Int) =
		ktor.get<CastResponse>(
			"${Constants.baseUrl}/movie/$idMovie/credits?api_key=${Constants.apiKey}"
		)

	suspend fun getVideo(idMovie: Int) =
		ktor.get<VideoResponse>(
			"${Constants.baseUrl}/movie/$idMovie/video?api_key=${Constants.apiKey}"
		)

}










