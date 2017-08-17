package lemonsoda.top.kotlinlearn.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by Chuan on 12/06/2017.
 */


fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}