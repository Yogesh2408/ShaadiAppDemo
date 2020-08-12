package yogesh.com.shaadiassignment.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yogesh.shaadiassignemt.dataclasses.Result

@Dao
interface UsersDao {

    @Query("SELECT * FROM result_table")
    fun getAllUsers(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(countryList: List<Result>)

    @Query("DELETE FROM result_table")
    fun deleteAllUsers()

    @Query("UPDATE result_table SET extraInfo = :string WHERE email = :emailId")
    fun updateUser(emailId: String, string: String)

    @Query("SELECT * FROM result_table WHERE extraInfo = :s")
    fun getUser(s: String?): LiveData<List<Result>>
}