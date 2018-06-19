package com.jcmsalves.londontubestatus.di

import com.jcmsalves.data.status.StatusRepositoryImpl
import com.jcmsalves.data.status.StatusService
import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.domain.status.StatusRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesStatusRepository(statusService: StatusService,
                                 mapper: LineStatusModelToLineStatusMapper):
        StatusRepository = StatusRepositoryImpl(statusService, mapper)
}
