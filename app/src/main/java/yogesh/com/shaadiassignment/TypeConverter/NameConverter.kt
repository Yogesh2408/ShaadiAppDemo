package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Name
import java.lang.reflect.Type

class NameConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Name? {
        val listType: Type = object : TypeToken<Name>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Name?): String? {
        return Gson().toJson(myObjects)
    }
}
