package com.solar.remote.mapper

import com.solar.data.model.FoodEntity
import com.solar.remote.response.FoodResponse


class FoodEntityMapper : EntityMapper<FoodResponse, FoodEntity> {
    override fun mapFromRemote(type: FoodResponse): FoodEntity {
        return FoodEntity(
            type.text ?: "",
            type.author ?: 0,
            type.feed_images ?: listOf()
        )
    }
}