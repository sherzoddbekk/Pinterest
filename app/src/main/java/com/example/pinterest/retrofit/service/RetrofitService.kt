package com.example.pinterest.retrofit.service
import com.example.pinterest.model.Photo
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @Headers(
        "Authorization: Client-ID nIwfjHyG20jyqL7sBF1PuhJwYX98uvFVm0MVCFuIrtU"
    )

    @GET("photos")
    fun  listPost(@Query("per_page") per_page: Int = 30,@Query("page")page:Int): Call<ArrayList<Photo>>

//    @POST("photos")
//    fun createPost(@Path("id") id: Int, @Body photo: com.example.pinterest.model.Photo):Call<com.example.pinterest.model.Photo>
//
//    @DELETE("photos/{id}")
//    fun updatePost(@Path("id") id: Int):Call<com.example.pinterest.model.Photo>
}