package com.solar.remote.service

import com.solar.remote.response.FoodResponse
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FoodService {
    @GET("api/feed/")
    fun getFeedList(): Single<List<FoodResponse>>

    @Multipart
    @POST("api/feed/")
    fun postFeed(
        @Part("text") text: String,
        @Part requestBody: MultipartBody.Part): Observable<Any>
}