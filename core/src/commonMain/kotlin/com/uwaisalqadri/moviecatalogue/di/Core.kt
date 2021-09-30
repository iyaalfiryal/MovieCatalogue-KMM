package com.uwaisalqadri.moviecatalogue.di

import co.touchlab.kermit.Kermit
import com.uwaisalqadri.moviecatalogue.data.mapper.entity.MovieEntityMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.CastResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.GenreResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.MovieResponseMapper
import com.uwaisalqadri.moviecatalogue.data.mapper.response.VideoResponseMapper
import com.uwaisalqadri.moviecatalogue.data.repository.DefaultMovieRepository
import com.uwaisalqadri.moviecatalogue.data.source.local.databaseModule
import com.uwaisalqadri.moviecatalogue.data.source.remote.RemoteDataSource
import com.uwaisalqadri.moviecatalogue.domain.repository.MovieRepository
import com.uwaisalqadri.moviecatalogue.domain.usecase.detail.*
import com.uwaisalqadri.moviecatalogue.domain.usecase.favorite.GetFavoriteMovieInteractor
import com.uwaisalqadri.moviecatalogue.domain.usecase.favorite.GetFavoriteMovieUseCase
import com.uwaisalqadri.moviecatalogue.domain.usecase.home.*
import com.uwaisalqadri.moviecatalogue.domain.usecase.search.GetSearchMovieInteractor
import com.uwaisalqadri.moviecatalogue.domain.usecase.search.GetSearchMovieUseCase
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Created by Uwais Alqadri on September 24, 2021
 */

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
	startKoin {
		appDeclaration()
		modules(remoteModule, repositoryModule, useCaseModule, mapperModule, databaseModule())
	}

// for iOS
fun initKoin() = initKoin {}

val mapperModule = module {
	single { MovieResponseMapper(get()) }
	single { CastResponseMapper() }
	single { VideoResponseMapper() }
	single { GenreResponseMapper() }
	single { MovieEntityMapper() }
}

val useCaseModule = module {
	single<GetPopularMovieUseCase> {
		GetPopularMovieInteractor(get())
	}

	single<GetUpComingMovieUseCase> {
		GetUpComingMovieInteractor(get())
	}

	single<GetBannerMovieUseCase> {
		GetBannerMovieInteractor(get())
	}

	single<GetSearchMovieUseCase> {
		GetSearchMovieInteractor(get())
	}

	single<GetDetailMovieUseCase> {
		GetDetailMovieInteractor(get())
	}

	single<GetCastMovieUseCase> {
		GetCastMovieInteractor(get())
	}

	single<GetVideoMovieUseCase> {
		GetVideoMovieInteractor(get())
	}

	single<GetGenreMovieUseCase> {
		GetGenreMovieInteractor(get())
	}

	single<GetFavoriteMovieUseCase> {
		GetFavoriteMovieInteractor(get())
	}
}

val repositoryModule = module {
	single<MovieRepository> {
		DefaultMovieRepository(get(), get(), get(), get(), get(), get())
	}
}

val remoteModule = module {
	single { RemoteDataSource(get()) }
	single { createJson() }
	single { createKtor(get()) }
	single { Kermit(logger = get()) }
}

fun createJson() = Json {
	isLenient = true
	ignoreUnknownKeys = true
	useAlternativeNames = false
}

fun createKtor(json: Json) = HttpClient {
	install(JsonFeature) {
		serializer = KotlinxSerializer(json)
	}

	install(Logging) {
		logger = Logger.DEFAULT
		level = LogLevel.INFO
	}
}