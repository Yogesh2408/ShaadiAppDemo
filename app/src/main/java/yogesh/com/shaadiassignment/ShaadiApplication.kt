package yogesh.com.shaadiassignment

import android.app.Application
import androidx.room.Room
import yogesh.com.shaadiassignment.DB.CountryDatabase

class ShaadiApplication : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "users_database").fallbackToDestructiveMigration().build()
    }
}