package yogesh.com.shaadiassignment.Retrofit

import com.yogesh.shaadiassignemt.dataclasses.Result
import retrofit2.Call
import retrofit2.http.GET
import yogesh.com.shaadiassignment.Model.Users

interface RestApi {

    @GET("/api/?results=10")
    fun getAllCountries(): Call<Users>
//    fun getAllCountries() : Call<List<CountryModel>>
}