package com.uwaisalqadri.moviecatalogue.utils

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.toLocalDate
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by Uwais Alqadri on October 01, 2021
 */

@SuppressLint("SimpleDateFormat")
actual fun formatDate(dateString: String, format: String): String {

	return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
		val dateFormat = DateTimeFormatter.ofPattern(Constants.formatFromApi)
		val currentDate = LocalDate.parse(dateString, dateFormat)
		currentDate.format(DateTimeFormatter.ofPattern(format))
	} else {
		val date = SimpleDateFormat(Constants.formatFromApi).parse(dateString)
		val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
		dateFormatter.format(date ?: Date())
	}

}