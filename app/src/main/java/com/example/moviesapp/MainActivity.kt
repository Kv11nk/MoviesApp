package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import com.example.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Column {
                    WeatherWindow()
                }
            }
        }
    }
}

@Composable
fun Temp(city: String){
    val api = remember {
        WeatherApi.getApi()
    }
    val weather by produceState(Weather(), city){
        value = api.weater(city)
    }
    Text(text = weather.current.temp_c.toString())
}