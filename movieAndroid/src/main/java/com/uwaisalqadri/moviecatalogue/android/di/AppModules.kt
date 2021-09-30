package com.uwaisalqadri.moviecatalogue.android.di

import com.uwaisalqadri.moviecatalogue.android.ui.detail.DetailViewModel
import com.uwaisalqadri.moviecatalogue.android.ui.favorite.FavoriteViewModel
import com.uwaisalqadri.moviecatalogue.android.ui.home.HomeViewModel
import com.uwaisalqadri.moviecatalogue.android.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Uwais Alqadri on September 24, 2021
 */

val viewModelModule = module {
	viewModel { HomeViewModel(get(), get(), get()) }
	viewModel { SearchViewModel(get()) }
	viewModel { DetailViewModel(get(), get(), get()) }
	viewModel { FavoriteViewModel(get()) }
}