package com.example.david.weatherkotlin.domain.commands

import com.example.david.weatherkotlin.data.ForecastRequest
import com.example.david.weatherkotlin.domain.mappers.ForecastDataMapper
import com.example.david.weatherkotlin.domain.model.ForecastList

/**
 * Created by david on 21/08/17.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}