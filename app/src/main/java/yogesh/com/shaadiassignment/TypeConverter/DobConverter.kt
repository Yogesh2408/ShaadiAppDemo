package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Dob
import java.lang.reflect.Type

class DobConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Dob? {
        val listType: Type = object : TypeToken<Dob>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Dob?): String? {
        return Gson().toJson(myObjects)
    }
}
