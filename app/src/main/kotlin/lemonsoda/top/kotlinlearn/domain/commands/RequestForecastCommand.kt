package lemonsoda.top.kotlinlearn.domain.commands

import lemonsoda.top.kotlinlearn.data.server.ForecastByZipCodeRequest
import lemonsoda.top.kotlinlearn.data.server.ServerDataMapper
import lemonsoda.top.kotlinlearn.domain.commands.Command
import lemonsoda.top.kotlinlearn.domain.datasource.ForecastProvider
import lemonsoda.top.kotlinlearn.domain.model.ForecastList

/**
 * Created by Chuan on 07/06/2017.
 */

class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)

}
