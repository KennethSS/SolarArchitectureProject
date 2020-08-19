package com.solar.architecture.dagger.component

import android.app.Application
import com.solar.architecture.dagger.Dagger2Application
import com.solar.architecture.dagger.module.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        RemoteModule::class,
        DomainModule::class
        ]
)
interface AppComponent {

    fun inject(instance: Dagger2Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}