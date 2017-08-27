package com.example.david.weatherkotlin.ui

import android.app.Application
import com.example.david.weatherkotlin.ui.utils.DelegatesExt

/**
 * Created by david on 27/08/17.
 */
class App: Application(){
    companion object {
        var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}