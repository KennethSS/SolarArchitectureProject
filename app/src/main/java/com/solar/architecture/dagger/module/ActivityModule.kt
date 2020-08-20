package com.solar.architecture.dagger.module

import com.solar.architecture.mvp.contract.FoodContract
import com.solar.architecture.mvp.presenter.FoodPresenter
import com.solar.architecture.mvvm.viewmodel.BasicViewModel
import com.solar.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    fun provideBasicViewModel(repository: FoodRepository): BasicViewModel {
        return BasicViewModel(repository)
    }

    @Provides
    internal fun provideFoodPresenter(repository: FoodRepository): FoodContract.Presenter {
        return FoodPresenter(repository)
    }
}