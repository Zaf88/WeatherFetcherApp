package com.example.weatherfetcher.feature.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherfetcher.R
import com.example.weatherfetcher.feature.ui.WeatherScreenViewModel
import com.example.weatherfetcher.feature.weather_screen.data.ui.DataEvent
import com.example.weatherfetcher.feature.weather_screen.data.ui.UiEvent
import org.koin.androidx.compose.getViewModel

@Preview(showBackground = true)
@Composable
fun CurrentCardItem(
    viewModel: WeatherScreenViewModel = getViewModel()
) {

    val viewState = viewModel.viewState.observeAsState()

    var city by rememberSaveable { mutableStateOf("Moscow") }
    viewModel.processDataEvent(DataEvent.WeatherIsLoaded(city))


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.12f)
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            //Карточка текущей даты
            Text(text = "Дата", color = Color.White)
            //Карточка города
            Text(text = viewState.value!!.city.capitalize(), color = Color.White, fontSize = 20.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.78f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = viewState.value!!.tempCurrent,
                        color = Color.White,
                        fontSize = 64.sp
                    )
                    Image(
                        painter = rememberImagePainter(
                            "http://openweathermap.org/img/wn/${viewState.value!!.iconCurrent}@2x.png"
                        ),
                        contentDescription = "imgCurrentcard",
                        modifier = Modifier.size(110.dp)
                    )
                }
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_switch_access_shortcut_add_24),
                        contentDescription = "imgWind",
                        modifier = Modifier.size(24.dp),
                    )
                    Text(
                        text = viewState.value!!.windDegCurrent,
                        color = Color.White, fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
//                    Text(text = viewState.value!!., color = Color.White, fontSize = 20.sp)
                }
                Text(
                    text = viewState.value!!.descriptionCurrent,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {
                    viewModel.processUiEvent(UiEvent.isSearchClicked)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "imSearch",
                    tint = Color.White,
                    modifier = Modifier.fillMaxHeight()
                )

            }
            if (viewState.value!!.isSearchVisible) {
                TextField(
                    value = city,
                    onValueChange = {
                        city = it
                    },
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.White,
                    ),
                    modifier = Modifier
                        .width(IntrinsicSize.Min)
                )
            }

            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
                    contentDescription = "imSearch",
                    tint = Color.White,
                )
            }
        }
    }

}