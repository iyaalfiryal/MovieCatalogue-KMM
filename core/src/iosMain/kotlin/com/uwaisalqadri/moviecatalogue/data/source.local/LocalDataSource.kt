package com.uwaisalqadri.moviecatalogue.data.source.local

import co.touchlab.kermit.Logger
import co.touchlab.kermit.NSLogLogger
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.uwaisalqadri.moviecatalogue.data.source.local.MovieDatabaseWrapper
import com.uwaisalqadri.moviecatalogue.db.MovieDB
import org.koin.dsl.module

/**
 * Created by Uwais Alqadri on September 29, 2021
 */
actual fun databaseModule() = module {
	single {
		val driver = NativeSqliteDriver(MovieDB.Schema, "moviecatalogue.db")
		MovieDatabaseWrapper(MovieDB(driver))
	}

	single<Logger> { NSLogLogger() }
}