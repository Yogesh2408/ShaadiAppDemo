package yogesh.com.shaadiassignment

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun getFormattedDate(dateStr: String): String {
        var formattedDate: String
        try {
            /** DEBUG dateStr = '2006-04-16T04:00:00Z' **/
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val dateValue = formatter.parse(dateStr) // this never ends while debugging
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            Log.e("mDate", dateValue.toString())
            formattedDate = dateFormat.format(dateValue)
        } catch (e: Exception) {
            Log.e("mDate", e.toString()) // this never gets called either
            formattedDate = "dd-MM-yyyy"
        }
        return formattedDate
    }


    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}