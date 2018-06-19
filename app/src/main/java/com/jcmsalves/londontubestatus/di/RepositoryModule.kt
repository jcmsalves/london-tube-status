package com.jcmsalves.londontubestatus.di

import com.jcmsalves.data.status.StatusRepositoryImpl
import com.jcmsalves.data.status.StatusService
import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesStatusRepository(statusService: StatusService,
                                 mapper: LineStatusModelToLineStatusMapper):
        StatusRepositoryImpl = StatusRepositoryImpl(statusService, mapper)
}
