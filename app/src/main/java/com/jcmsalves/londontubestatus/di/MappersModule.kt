package com.jcmsalves.londontubestatus.di

import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MappersModule {

    @Provides
    @Singleton
    fun provideLineStatusModelToLineStatusMapper(): LineStatusModelToLineStatusMapper =
        LineStatusModelToLineStatusMapper()
}
