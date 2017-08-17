package lemonsoda.top.kotlinlearn.data.server

import lemonsoda.top.kotlinlearn.data.db.ForecastDb
import lemonsoda.top.kotlinlearn.domain.datasource.ForecastDataSource
import lemonsoda.top.kotlinlearn.domain.model.ForecastList

/**
 * Created by Chuan on 14/06/2017.
 */

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

}