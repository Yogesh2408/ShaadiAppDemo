package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Coordinates
import java.lang.reflect.Type

class CoordinatesConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Coordinates? {
        val listType: Type = object : TypeToken<Coordinates>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Coordinates?): String? {
        return Gson().toJson(myObjects)
    }
}
