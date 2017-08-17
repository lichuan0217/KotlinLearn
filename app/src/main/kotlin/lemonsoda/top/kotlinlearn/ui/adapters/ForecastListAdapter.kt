package lemonsoda.top.kotlinlearn.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import lemonsoda.top.kotlinlearn.domain.model.Forecast
import lemonsoda.top.kotlinlearn.domain.model.ForecastList

import lemonsoda.top.kotlinlearn.R
import lemonsoda.top.kotlinlearn.extensions.cxt

import kotlinx.android.synthetic.main.layout_forecast_item.view.*
import lemonsoda.top.kotlinlearn.extensions.toDateString

/**
 * Created by Chuan on 07/06/2017.
 */

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent?.cxt)
                .inflate(R.layout.layout_forecast_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.cxt).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

}