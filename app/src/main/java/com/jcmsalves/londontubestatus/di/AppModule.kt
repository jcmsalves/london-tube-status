package com.jcmsalves.londontubestatus.di

import android.content.Context
import com.jcmsalves.codewarsapi.domain.RxSchedulers
import com.jcmsalves.data.RxSchedulersImpl
import com.jcmsalves.londontubestatus.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context = app

    @Provides
    fun provideRxSchedulers(): RxSchedulers = RxSchedulersImpl()
}
