package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Registered
import java.lang.reflect.Type

class RegisteredConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Registered? {
        val listType: Type = object : TypeToken<Registered>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Registered?): String? {
        return Gson().toJson(myObjects)
    }
}
