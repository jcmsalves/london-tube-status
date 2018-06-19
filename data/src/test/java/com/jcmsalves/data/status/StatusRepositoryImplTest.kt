package com.jcmsalves.data.status

import com.jcmsalves.data.status.model.LineStatusModelToLineStatusMapper
import com.jcmsalves.domain.status.StatusRepository
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class StatusRepositoryImplTest {

    private val mockStatusService = mock<StatusService>()
    private lateinit var statusRepository: StatusRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        statusRepository = StatusRepositoryImpl(mockStatusService, LineStatusModelToLineStatusMapper())
    }

    @Test
    fun shouldReturnThrowableWhenItFailsToFetchLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockStatusService.getStatus()).thenReturn(Single.error(throwable))

        // when
        val testObserver = statusRepository.getLinesStatus().test()

        // then
        testObserver.assertError(throwable)
        verify(mockStatusService).getStatus()
    }

    @Test
    fun shouldReturnLinesStatusWhenItSucceedsToFetchThem() {
        // given
        whenever(mockStatusService.getStatus())
            .thenReturn(Single.just(listOf(getLineStatusModel(), getLineStatusModel())))

        // when
        val testObserver = statusRepository.getLinesStatus().test()

        // then
        testObserver.assertNoErrors()
        testObserver.assertValue {
            it[0].id === getExpectedLineStatus().id
        }
        verify(mockStatusService).getStatus()
    }
}
