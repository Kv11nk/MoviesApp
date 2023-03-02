package com.example.moviesapp

class Current (
    val temp_c: Float = 0f,
    val condition: Condition = Condition()
)

class Weather(
    val current: Current = Current()
)

class Condition(
    val text: String = ""
)