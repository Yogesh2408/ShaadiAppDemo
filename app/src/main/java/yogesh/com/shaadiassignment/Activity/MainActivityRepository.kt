package yogesh.com.shaadiassignment.Activity

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.yogesh.shaadiassignemt.dataclasses.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yogesh.com.shaadiassignment.Model.Users
import yogesh.com.shaadiassignment.Retrofit.RestApi
import yogesh.com.shaadiassignment.ShaadiApplication

class MainActivityRepository {

    val BASE_URL = "https://randomuser.me"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getUsers(): LiveData<List<Result>> {
        return ShaadiApplication.database!!.usersDao().getAllUsers()
    }

    fun ApiCallAndPutInDB() {
        val gson = Gson()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllCountries().enqueue(object : Callback<Users> {

            override fun onFailure(call: Call<Users>?, t: Throwable?) {
                Log.e(TAG, "OOPS!! something went wrong..")
            }

            override fun onResponse(call: Call<Users>?, response: Response<Users>?) {
                Log.e(TAG, response!!.body().toString())
                when (response.code()) {
                    200 -> {
                        Thread(Runnable {
//                            ShaadiApplication.database!!.usersDao().deleteAllUsers()
                            ShaadiApplication.database!!.usersDao().insertAllUsers(response.body()!!.results)
                        }).start()
                    }
                }

            }
        })

    }

    fun updateUsersInDB(emailId: String, string: String) {
        Thread(Runnable {
            ShaadiApplication.database!!.usersDao().updateUser(emailId, string)
        }).start()
    }

    fun getUserFromDB(s: String): LiveData<List<Result>> {
        return ShaadiApplication.database!!.usersDao().getUser(s)
    }
}