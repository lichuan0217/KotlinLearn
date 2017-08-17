package lemonsoda.top.kotlinlearn.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import lemonsoda.top.kotlinlearn.ui.adapters.ForecastListAdapter
import lemonsoda.top.kotlinlearn.R
import lemonsoda.top.kotlinlearn.domain.commands.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.toast

import kotlinx.android.synthetic.main.activity_main.*
import lemonsoda.top.kotlinlearn.extensions.toDateString

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWeather.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread {
                longToast("Request performed")
                rvWeather.adapter = ForecastListAdapter(result) {
                    toast(it.date.toDateString())
                }
            }
        }
    }
}
