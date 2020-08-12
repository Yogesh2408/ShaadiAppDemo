package yogesh.com.shaadiassignment.Activity

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yogesh.shaadiassignemt.dataclasses.Result

class MainActivityViewModel : ViewModel() {

    var mainActivityRepository: MainActivityRepository

    init {
        mainActivityRepository = MainActivityRepository()
    }

    fun getAllUsersList(): LiveData<List<Result>> {
        return mainActivityRepository.getUsers()
    }

    fun getUsersFromAPIAndStore() {
        mainActivityRepository.ApiCallAndPutInDB()
    }

    fun updateUserData(emailId: String, string: String) {
        mainActivityRepository.updateUsersInDB(emailId, string)
    }

    fun getUserData(s: String): LiveData<List<Result>> {
        if (TextUtils.isEmpty(s)) {
            return getAllUsersList()
        } else {
            return mainActivityRepository.getUserFromDB(s)
        }
    }
}