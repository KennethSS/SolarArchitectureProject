package com.solar.architecture.dagger.module

import com.solar.architecture.mvp.contract.FoodContract
import com.solar.architecture.mvp.presenter.FoodPresenter
import com.solar.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    internal fun provideFoodPresenter(foodRepository: FoodRepository): FoodContract.Presenter {
        return FoodPresenter(foodRepository)
    }
}