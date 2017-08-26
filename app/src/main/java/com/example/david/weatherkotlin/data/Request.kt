package com.example.david.weatherkotlin.data

import android.util.Log
import java.net.URL

/**
 * Created by david on 19/08/17.
 */
class Request(val url : String){
    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}