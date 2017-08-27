package com.example.david.weatherkotlin.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.david.weatherkotlin.R
import com.example.david.weatherkotlin.domain.commands.RequestForecastCommand
import com.example.david.weatherkotlin.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf<String>("Lunes 6/23 - Sunny - 31/17",
            "Martes 6/24 - Foggy -21/17",
            "Miércoles 6/24 - Foggy -21/17",
            "Jueves 6/24 - Foggy -21/17")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        //anko
        //val forecastList:RecyclerView = find(R.id.forecast_list)

        //hacemos uso de extensions
        forecastList.layoutManager = LinearLayoutManager(this)
        //forecastList.adapter = ForecastListAdapter(items)

        /*val url = "http://api.openweathermap.org/data/2.5/forecast/daily?"+
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

        doAsync {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }*/

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                /*forecastList.adapter = ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: Forecast) {
                        toast(forecast.date)
                    }
                })*/

                /*val adapter = ForecastListAdapter(result){
                    forecast -> toast(forecast.date)
                }*/

                val adapter = ForecastListAdapter(result){
                    toast(it.date)
                }
                forecastList.adapter = adapter
            }
        }
    }
}
