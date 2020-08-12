package yogesh.com.shaadiassignment.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yogesh.shaadiassignemt.dataclasses.*
import yogesh.com.shaadiassignment.TypeConverter.*

@Database(entities = arrayOf(Coordinates::class, Dob::class, Id::class, Location::class,
        Login::class, Name::class,
        Picture::class, Registered::class, Result::class, Street::class, Timezone::class)
        , version = 1, exportSchema = false)

@TypeConverters(*arrayOf(CoordinatesConverter::class, DobConverter::class, IdConverter::class, LocationConverter::class,
        LoginTypeConverter::class, NameConverter::class, PictureConverter::class, RegisteredConverter::class,
        StreetConverter::class, TimeZoneConverter::class, PostCodeAnyConverter::class))
abstract class CountryDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao
}