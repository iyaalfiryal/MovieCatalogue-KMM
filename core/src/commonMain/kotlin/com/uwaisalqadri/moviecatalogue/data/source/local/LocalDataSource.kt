package com.uwaisalqadri.moviecatalogue.data.source.local

import com.uwaisalqadri.moviecatalogue.db.MovieDatabase
import org.koin.core.module.Module

/**
 * Created by Uwais Alqadri on September 24, 2021
 */
expect fun databaseModule(): Module
class MovieDatabaseWrapper(val instance: MovieDatabase?)