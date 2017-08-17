package lemonsoda.top.kotlinlearn.domain.datasource

import lemonsoda.top.kotlinlearn.data.db.ForecastDb
import lemonsoda.top.kotlinlearn.data.server.ForecastServer
import lemonsoda.top.kotlinlearn.domain.model.ForecastList
import lemonsoda.top.kotlinlearn.extensions.firstResult

/**
 * Created by Chuan on 14/06/2017.
 */

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(
            f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}