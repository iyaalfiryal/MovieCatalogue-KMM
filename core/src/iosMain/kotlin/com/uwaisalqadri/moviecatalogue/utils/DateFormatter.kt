package com.uwaisalqadri.moviecatalogue.utils

import platform.Foundation.*

/**
 * Created by Uwais Alqadri on October 01, 2021
 */
actual fun formatDate(dateString: String, format: String): String {

	val dateFormatter = NSDateFormatter().apply {
		dateFormat = Constants.formatFromApi
	}

	val formatter = NSDateFormatter().apply {
		dateFormat = format
		locale = NSLocale(localeIdentifier = "id_ID")
	}


	return formatter.stringFromDate(dateFormatter.dateFromString(dateString) ?: NSDate())

}