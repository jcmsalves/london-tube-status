package com.jcmsalves.domain.status

import com.jcmsalves.codewarsapi.domain.TestRxSchedulersImpl
import com.jcmsalves.domain.status.model.LineStatus
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetLinesStatusInteractorTest {

    private val mockStatusRepository = mock<StatusRepository>()
    private lateinit var getLinesStatusInteractor: GetLinesStatusInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getLinesStatusInteractor = GetLinesStatusInteractor(
            mockStatusRepository,
            TestRxSchedulersImpl()
        )
    }

    @Test
    fun shouldReturnErrorWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockStatusRepository.getLinesStatus())
            .thenReturn(Single.error(throwable))

        // when
        val testObserver = getLinesStatusInteractor.execute().test()

        // then
        testObserver.assertError(throwable)
        verify(mockStatusRepository).getLinesStatus()
    }

    @Test
    fun shouldReturnListOfLineStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockStatusRepository.getLinesStatus())
            .thenReturn(Single.just(mutableListOf(getLineStatus())))

        // when
        val testObserver = getLinesStatusInteractor.execute().test()

        // then
        verify(mockStatusRepository).getLinesStatus()
        testObserver.assertComplete()
        testObserver.assertValue {
            it[0] == getLineStatus()
        }
    }

    private fun getLineStatus(): LineStatus {
        return LineStatus(
            id = "id",
            name = "name",
            severityLevel = "severity_level",
            severityLevelDescription = "severity_level_description"
        )
    }
}
