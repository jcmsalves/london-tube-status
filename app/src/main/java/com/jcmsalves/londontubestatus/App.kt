package com.jcmsalves.londontubestatus

import android.app.Application
import com.jcmsalves.data.di.networkModule
import com.jcmsalves.londontubestatus.di.*
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule,
            viewsModule,
            repositoryModule,
            interactorsModule,
            mappersModule,
            networkModule))
    }
}
