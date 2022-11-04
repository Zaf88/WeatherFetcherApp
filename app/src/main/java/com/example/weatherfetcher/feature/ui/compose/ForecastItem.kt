package com.example.weathercompose.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherfetcher.feature.data.WeatherMainModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun ForecastItem(item: WeatherMainModel) {
    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formatedDay = LocalDate.parse(item.allDateWeather, firstApiFormat).dayOfMonth.toString()
    val formatedMonth = LocalDate.parse(item.allDateWeather, firstApiFormat).monthValue.toString()
    val formatedDayWeek = LocalDate.parse(item.allDateWeather, firstApiFormat).dayOfWeek.toString()

    fun dayToRusLang(day: String): String {
        if (day == "MONDAY") return "ПН"
        if (day == "TUESDAY") return "ВТ"
        if (day == "WEDNESDAY") return "СР"
        if (day == "THURSDAY") return "ЧТ"
        if (day == "FRIDAY") return "ПТ"
        if (day == "SATURDAY") return "СБ"
        if (day == "SUNDAY") return "ВС"
        return ""
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.8f)
            .padding(top = 4.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = DarkGray,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(text = "${formatedDay}/${formatedMonth}", color = Color.White, fontSize = 14.sp)
                Text(text = dayToRusLang(formatedDayWeek), color = Color.White, fontSize = 14.sp)
            }
            Text(text = item.description, color = Color.White, fontSize = 14.sp)
            Text(text = "${item.temperature.toInt()}°", color = Color.White, fontSize = 14.sp)
            Image(
                painter = rememberImagePainter(
                    "http://openweathermap.org/img/wn/${item.icon}@2x.png",

                ),
                contentDescription = "ImgHoursWeather",
                modifier = Modifier.size(24.dp),
            )
        }
    }
}