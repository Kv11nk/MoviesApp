package com.example.moviesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query



interface WeatherApi{
    @GET("current.json")
    suspend fun weater(
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no",
        @Query("key") key: String = API_KEY
    ): Weather

    companion object{
        val API_KEY = "a661844ac9ff4de98bd102341230103"

        fun getApi() = Retrofit
            .Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<WeatherApi>()
    }
}