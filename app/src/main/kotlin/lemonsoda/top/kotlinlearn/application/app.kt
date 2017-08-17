package lemonsoda.top.kotlinlearn.application

import android.app.Application
import lemonsoda.top.kotlinlearn.extensions.NotNullSingleValueVar
import kotlin.properties.Delegates

/**
 * Created by Chuan on 09/06/2017.
 */

class App : Application() {

    companion object {
        //var instance : App by Delegates.notNull()
        var instance: App by NotNullSingleValueVar()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}