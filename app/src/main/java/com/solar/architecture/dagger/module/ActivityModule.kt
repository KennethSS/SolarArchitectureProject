package com.solar.architecture.dagger.module

import android.app.Activity
import com.solar.architecture.MainActivity
import com.solar.architecture.viewmodel.BasicViewModel
import com.solar.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
class ActivityModule {
    @Provides
    fun provideBasicViewModel(repository: FoodRepository): BasicViewModel {
        return BasicViewModel(repository)
    }
}