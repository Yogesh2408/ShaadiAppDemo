package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Login
import java.lang.reflect.Type


class LoginTypeConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Login? {
        val listType: Type = object : TypeToken<Login>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Login?): String? {
        return Gson().toJson(myObjects)
    }
}