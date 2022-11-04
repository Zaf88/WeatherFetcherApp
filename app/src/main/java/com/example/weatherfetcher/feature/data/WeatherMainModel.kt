package com.example.weatherfetcher.feature.data

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class WeatherMainModel(
    val description: String,
    val icon: String,
    val temperature: Double,
    val windDeg: String,
    val windSpeed: String,
    val allDateWeather:String
)
{
//    fun toTextualDescription(windDeg: String): String {
//        if (windDeg.toFloat() > 337.5) return "Северный"
//        if (windDeg.toFloat() > 292.5) return "Северо-западный"
//        if (windDeg.toFloat() > 247.5) return "Западный"
//        if (windDeg.toFloat() > 202.5) return "Юго-западный"
//        if (windDeg.toFloat() > 157.5) return "Южный"
//        if (windDeg.toFloat() > 122.5) return "Юго-Восточный"
//        if (windDeg.toFloat() > 67.5) return "Восточный"
//        if (windDeg.toFloat() > 22.5)  return "Северо-восточный"
//        return ""
//    }

    fun toTextualDescription(windDeg: String): String {
        if (windDeg.toFloat() > 337.5) return "С"
        if (windDeg.toFloat() > 292.5) return "СЗ"
        if (windDeg.toFloat() > 247.5) return "З"
        if (windDeg.toFloat() > 202.5) return "ЮЗ"
        if (windDeg.toFloat() > 157.5) return "Ю"
        if (windDeg.toFloat() > 122.5) return "ЮВ"
        if (windDeg.toFloat() > 67.5) return "В"
        if (windDeg.toFloat() > 22.5)  return "СВ"
        return ""
    }

    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun formatToDayName( date:String):String {
        val formatedDay = LocalDate.parse(date, firstApiFormat).dayOfWeek.toString()
        return formatToDayName(formatedDay)
    }
    fun formatToDayNumber( date:String):String {
        return LocalDate.parse(date, firstApiFormat).dayOfMonth.toString()
    }

    fun dayToRusLang(day: String): String {
        if (day =="MONDAY") return "ПН"
        if (day =="TUESDAY") return "ВТ"
        if (day =="WEDNESDAY") return "СР"
        if (day =="THURSDAY") return "ЧТ"
        if (day =="FRIDAY") return "ПТ"
        if (day =="SATURDAY") return "СБ"
        if (day =="SUNDAY") return "ВС"
        return ""
    }

    fun formateToHour(date:String):String {
        return  LocalTime.parse(date, firstApiFormat).hour.toString()
    }
}