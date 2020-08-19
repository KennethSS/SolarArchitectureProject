package com.solar.data.repository

import com.solar.data.model.FoodEntity
import io.reactivex.Observable
import io.reactivex.Single

interface FoodRemote {
    fun getFoodList(): Single<List<FoodEntity>>
    fun postFood(feed: FoodEntity): Observable<Any>
}