package yogesh.com.shaadiassignment.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogesh.shaadiassignemt.dataclasses.Picture
import java.lang.reflect.Type

class PictureConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): Picture? {
        val listType: Type = object : TypeToken<Picture>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: Picture?): String? {
        return Gson().toJson(myObjects)
    }
}
