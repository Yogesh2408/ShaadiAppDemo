package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Timezone
import java.lang.reflect.Type

class TimeZoneConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Timezone? {
        val listType: Type = object : TypeToken<Timezone>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Timezone?): String? {
        return Gson().toJson(myObjects)
    }
}
