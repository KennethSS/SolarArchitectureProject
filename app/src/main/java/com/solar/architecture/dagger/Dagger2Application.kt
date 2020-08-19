package com.solar.architecture.dagger

import android.app.Application
import com.solar.architecture.dagger.component.AppComponent
import com.solar.architecture.dagger.component.DaggerAppComponent

class Dagger2Application : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}