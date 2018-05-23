package com.jcmsalves.londontubestatus

import android.app.Application
import com.jcmsalves.londontubestatus.di.AppModule
import com.jcmsalves.londontubestatus.di.ApplicationComponent
import com.jcmsalves.londontubestatus.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
