package com.solar.data.mapper

import com.solar.data.model.FoodEntity
import com.solar.domain.model.Food

class FoodMapper : Mapper<FoodEntity, Food> {
    override fun mapFromEntity(type: FoodEntity): Food {
        return Food(
            type.name,
            type.price,
            type.images
        )
    }

    override fun mapToEntity(type: Food): FoodEntity {
        return FoodEntity(
            type.name,
            type.price,
            type.images
        )
    }
}