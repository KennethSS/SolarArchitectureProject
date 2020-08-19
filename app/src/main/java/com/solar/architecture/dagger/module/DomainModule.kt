package com.solar.architecture.dagger.module

import com.solar.data.impl.FoodDataRepositoryImpl
import com.solar.data.mapper.FoodMapper
import com.solar.data.repository.FoodRemote
import com.solar.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    companion object {
        @Provides
        fun provideFoodRepository(foodRemote: FoodRemote): FoodRepository {
            return FoodDataRepositoryImpl(foodRemote, FoodMapper())
        }
    }
}

