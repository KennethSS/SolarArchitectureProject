package com.solar.architecture.dagger.component

import com.solar.architecture.MainActivity
import com.solar.architecture.dagger.module.ActivityModule
import com.solar.architecture.dagger.module.DomainModule
import com.solar.architecture.dagger.module.RemoteModule
import com.solar.architecture.dagger.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        RemoteModule::class,
        DomainModule::class,
        ActivityModule::class
    ]
)
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}