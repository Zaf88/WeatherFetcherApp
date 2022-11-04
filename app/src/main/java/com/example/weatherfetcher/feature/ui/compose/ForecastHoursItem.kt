package com.example.weathercompose.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherfetcher.feature.data.WeatherMainModel
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@Composable
fun ForecastHoursItem(item: WeatherMainModel) {

    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formattedTime = "${LocalTime.parse(item.allDateWeather, firstApiFormat).hour}:00"

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            text = formattedTime,
            fontSize = 12.sp,
            color = Color.White
        )
        Image(
            painter = rememberImagePainter(
                "http://openweathermap.org/img/wn/${item.icon}@2x.png"
            ),
            contentDescription = "ImgHoursWeather",
            modifier = Modifier.size(60.dp),
        )
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            text = "${item.temperature.toInt()}°", color = Color.White
        )
    }
}
