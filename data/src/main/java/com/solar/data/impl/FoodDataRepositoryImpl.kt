package com.solar.data.impl

import com.solar.data.mapper.FoodMapper
import com.solar.data.repository.FoodRemote
import com.solar.domain.model.Food
import com.solar.domain.repository.FoodRepository
import io.reactivex.Observable
import io.reactivex.Single

class FoodDataRepositoryImpl(
    private val foodRemote: FoodRemote,
    private val foodMapper: FoodMapper
) : FoodRepository {
    override fun getFeedList(): Single<List<Food>> {
        return foodRemote.getFoodList().map { list -> list.map { foodMapper.mapFromEntity(it) } }
    }

    override fun postFeed(food: Food): Observable<Any> {
        return foodRemote.postFood(foodMapper.mapToEntity(food))
    }
}