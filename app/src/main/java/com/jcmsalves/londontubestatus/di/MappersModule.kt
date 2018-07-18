package com.jcmsalves.londontubestatus.di

import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideLineStatusModelToLineStatusMapper() =
        LineStatusModelToLineStatusMapper()

    @Provides
    fun provideLineStatusToLineStatusPresentationMapper() =
        LineStatusToLineStatusPresentationMapper()
}
