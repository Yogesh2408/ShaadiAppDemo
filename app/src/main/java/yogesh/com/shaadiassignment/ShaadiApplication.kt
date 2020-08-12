package yogesh.com.shaadiassignment

import android.app.Application
import androidx.room.Room
import yogesh.com.shaadiassignment.DB.UsersDatabase

class ShaadiApplication : Application() {

    companion object {
        var database: UsersDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, UsersDatabase::class.java, "users_database").fallbackToDestructiveMigration().build()
    }
}