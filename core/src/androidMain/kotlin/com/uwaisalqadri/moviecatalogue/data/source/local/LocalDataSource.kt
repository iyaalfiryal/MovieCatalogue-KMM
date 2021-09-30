package com.uwaisalqadri.moviecatalogue.data.source.local

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.uwaisalqadri.moviecatalogue.db.MovieDatabase
import org.koin.dsl.module

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
actual fun databaseModule() = module {
	single {
		val driver = AndroidSqliteDriver(MovieDatabase.Schema, get(), "moviecatalogue.db")
		MovieDatabaseWrapper(MovieDatabase(driver))
	}

	single<Logger> { LogcatLogger() }
}