package com.example.moviesapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import java.time.LocalDateTime

val time = LocalDateTime.now()


val morning: Boolean = time.hour > 4 && time.hour <= 10
val day: Boolean = time.hour > 10 && time.hour <= 18
val evening: Boolean = time.hour > 18 && time.hour <= 22
val night: Boolean = time.hour > 22 && time.hour >= 4


@Composable
fun BackgroundTime(){
    if (morning) Image(painterResource(R.drawable.ytro), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.FillHeight)
    else if (day) Image(painterResource(R.drawable.day), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.FillHeight)
    else if (evening) Image(painterResource(R.drawable.vecher), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.FillHeight)
    else if (night) Image(painterResource(R.drawable.night), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.FillHeight)
    else Text(text = "")
}

@Composable
fun TextTime(){
    if (morning) Text(text = "Доброе утро")
    else if (day) Text(text = "Добрый день")
    else if (evening) Text(text = "Добрый вечер")
    else if (night) Text(text = "Доброй ночи")
    else Text(text = "")
}