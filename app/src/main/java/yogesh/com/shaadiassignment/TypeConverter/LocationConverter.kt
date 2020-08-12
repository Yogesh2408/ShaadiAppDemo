package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Location
import java.lang.reflect.Type

class LocationConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Location? {
        val listType: Type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Location?): String? {
        return Gson().toJson(myObjects)
    }
}
