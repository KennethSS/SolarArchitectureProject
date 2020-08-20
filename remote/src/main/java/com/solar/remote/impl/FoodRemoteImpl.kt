package com.solar.remote.impl

import com.solar.data.model.FoodEntity
import com.solar.data.repository.FoodRemote
import com.solar.remote.mapper.FoodEntityMapper
import com.solar.remote.service.FoodService
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.net.URI

class FoodRemoteImpl(
    private val foodService: FoodService,
    private val feedEntityMapper: FoodEntityMapper
) : FoodRemote {
    override fun getFoodList(): Single<List<FoodEntity>> {
        print("getFoodList")
        //return Single.just(listOf(FoodEntity("sdf", 0, listOf())))
        return foodService.getFeedList()
            .map { list ->
                print("getFoodList" + list.size)
                list.map { feedEntityMapper.mapFromRemote(it) }
            }
    }

    override fun postFood(food: FoodEntity): Observable<Any> {
        val builder = MultipartBody.Builder().apply {
            addFormDataPart("text", food.name)
            food.images.forEach {
                val file = if (it.startsWith("files://")) {
                    File(URI(it))
                } else {
                    File(it)
                }
                print("file " + file.absolutePath + " is Absolute")
            }
        }
        val file = File(food.images[0])
        val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        //addFormDataPart("image", file.name, requestBody)
        val body=  MultipartBody.Part.createFormData("image", file.name, requestBody)

        return foodService.postFeed(food.name, body)
    }
}