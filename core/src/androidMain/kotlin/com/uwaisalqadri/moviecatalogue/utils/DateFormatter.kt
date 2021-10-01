package com.uwaisalqadri.moviecatalogue.utils

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.toLocalDate
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

/**
 * Created by Uwais Alqadri on October 01, 2021
 */

@RequiresApi(Build.VERSION_CODES.O)
actual fun formatDate(dateString: String, format: String): String {
	@SuppressLint("SimpleDateFormat")
	val dateFormat = DateTimeFormatter.ofPattern(Constants.formatFromApi)

	val currentDate = LocalDate.parse(dateString, dateFormat)
	return currentDate.format(DateTimeFormatter.ofPattern(format))
}