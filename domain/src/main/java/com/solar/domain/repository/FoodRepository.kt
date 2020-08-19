package com.solar.domain.repository

import com.solar.domain.model.Food
import io.reactivex.Observable
import io.reactivex.Single

interface FoodRepository {
    fun getFeedList(): Single<List<Food>>

    fun postFeed(food: Food): Observable<Any>
}