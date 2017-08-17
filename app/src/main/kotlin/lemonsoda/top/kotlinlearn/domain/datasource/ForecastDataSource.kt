package lemonsoda.top.kotlinlearn.domain.datasource

import lemonsoda.top.kotlinlearn.domain.model.ForecastList

/**
 * Created by Chuan on 14/06/2017.
 */

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}