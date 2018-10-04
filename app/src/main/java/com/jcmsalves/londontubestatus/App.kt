package com.jcmsalves.londontubestatus

import android.app.Application
import com.jcmsalves.data.di.networkModule
import com.jcmsalves.londontubestatus.di.appModule
import com.jcmsalves.londontubestatus.di.interactorsModule
import com.jcmsalves.londontubestatus.di.mappersModule
import com.jcmsalves.londontubestatus.di.repositoryModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule,
            repositoryModule,
            interactorsModule,
            mappersModule,
            networkModule))
    }
}
