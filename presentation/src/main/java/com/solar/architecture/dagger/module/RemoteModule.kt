package com.solar.architecture.dagger.module

import com.solar.architecture.BuildConfig
import com.solar.data.repository.FoodRemote
import com.solar.remote.impl.FoodRemoteImpl
import com.solar.remote.mapper.FoodEntityMapper
import com.solar.remote.retrofit.ApiClient
import com.solar.remote.service.FoodService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class RemoteModule {

    @Provides
    fun provideFoodService(): FoodService {
        return ApiClient.provideAppService(BuildConfig.DEBUG)
    }

    @Provides
    fun provideFeedRemoteImpl(foodService: FoodService): FoodRemote {
        return FoodRemoteImpl(foodService, FoodEntityMapper())
    }
}