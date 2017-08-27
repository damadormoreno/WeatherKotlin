package com.example.david.weatherkotlin.domain.mappers

import android.icu.text.DateFormat
import com.example.david.weatherkotlin.data.Forecast
import com.example.david.weatherkotlin.data.ForecastResult
import com.example.david.weatherkotlin.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit

import com.example.david.weatherkotlin.domain.model.Forecast as ModelForecast

/**
 * Created by david on 21/08/17.
 */
class ForecastDataMapper{
    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>{
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast : Forecast) : ModelForecast{
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long) : String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}