package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Id
import java.lang.reflect.Type

class IdConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Id? {
        val listType: Type = object : TypeToken<Id>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Id?): String? {
        return Gson().toJson(myObjects)
    }
}
