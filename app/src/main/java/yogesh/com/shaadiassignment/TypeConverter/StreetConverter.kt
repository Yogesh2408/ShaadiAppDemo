package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Street
import java.lang.reflect.Type

class StreetConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Street? {
        val listType: Type = object : TypeToken<Street>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Street?): String? {
        return Gson().toJson(myObjects)
    }
}
