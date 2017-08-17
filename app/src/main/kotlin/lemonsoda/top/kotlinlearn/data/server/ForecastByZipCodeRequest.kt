package lemonsoda.top.kotlinlearn.data.server

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Chuan on 07/06/2017.
 */

class ForecastByZipCodeRequest(private val zipCode: Long) {

    companion object {
        private val APP_ID = "e9b0f7e963ecb0c2b6ef96d2649e6884"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }


    fun execute(): ForecastResult {
        val forecastJson = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJson)
        return Gson().fromJson(forecastJson, ForecastResult::class.java)
    }
}