package com.jcmsalves.londontubestatus.di

import android.content.Context
import com.jcmsalves.londontubestatus.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context = app
}
