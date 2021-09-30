package com.uwaisalqadri.moviecatalogue.android

import android.app.Application
import co.touchlab.kermit.Kermit
import com.uwaisalqadri.moviecatalogue.android.di.viewModelModule
import com.uwaisalqadri.moviecatalogue.di.initKoin
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
class BaseApplication: Application(), KoinComponent {
	private val logger: Kermit by inject()

	override fun onCreate() {
		super.onCreate()

		initKoin {
			androidLogger()
			androidContext(this@BaseApplication)
			modules(
				viewModelModule
			)
		}

		logger.d { "BaseApplication" }

	}
}