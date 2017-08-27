package com.example.david.weatherkotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.david.weatherkotlin.R
import com.example.david.weatherkotlin.domain.model.Forecast
import com.example.david.weatherkotlin.domain.model.ForecastList
import com.example.david.weatherkotlin.ui.utils.ctx
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by david on 19/08/17.
 */
public class ForecastListAdapter(val weekForecast: ForecastList,
                                 val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun getItemCount() = weekForecast.size //weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //with(weekForecast.dailyForecast[position])
        //with(weekForecast[position])
        //{
            //holder.textView.text = "$date - $description - $high/$low"
            holder.bindForecast(weekForecast[position])
        //}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    //class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    class ViewHolder(view: View, val itemClick : (Forecast) -> Unit) : RecyclerView.ViewHolder(view){
        /*private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)*/

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Glide.with(itemView.ctx).load(icon).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener {
                    itemClick(this)
                }

            }
        }
    }
}