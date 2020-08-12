package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class PostCodeAnyConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Any? {
        val listType: Type = object : TypeToken<Any>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Any?): String? {
        return Gson().toJson(myObjects)
    }
}
