package com.solar.architecture.dagger.module

import androidx.lifecycle.ViewModel
import com.solar.architecture.viewmodel.BasicViewModel
import com.solar.data.repository.FoodRemote
import com.solar.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(BasicViewModel::class)
    fun provideBasicViewModel(repository: FoodRepository): ViewModel {
        return BasicViewModel(repository)
    }
}