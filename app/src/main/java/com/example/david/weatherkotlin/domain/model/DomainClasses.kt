package com.example.david.weatherkotlin.domain.model

/**
 * Created by david on 21/08/17.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){
    val size: Int
    get() = dailyForecast.size
    //operator fun get(position: Int): Forecast = dailyForecast[position]
    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int,
                    val icon: String)