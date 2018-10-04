package com.jcmsalves.londontubestatus.status.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.londontubestatus.status.getExpectedLineStatusPresentation
import com.jcmsalves.londontubestatus.status.getLineStatus
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations

class StatusViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val mockGetLinesStatusInteractor = mock<GetLinesStatusInteractor>()
    private lateinit var statusViewModel: StatusViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        statusViewModel = StatusViewModel(mockGetLinesStatusInteractor,
            LineStatusToLineStatusPresentationMapper())
    }

    @Test
    fun shouldPostErrorStateWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockGetLinesStatusInteractor.execute())
            .thenReturn(Observable.error(throwable))

        // when
        statusViewModel.fetchLinesStatus()

        // then
        verify(mockGetLinesStatusInteractor).execute()
        assert(statusViewModel.linesStatusLiveData.value
            == StatusState.Error)
    }

    @Test
    fun shouldTriggerShowLinesStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockGetLinesStatusInteractor.execute())
            .thenReturn(Observable.just(listOf(getLineStatus())))

        // when
        statusViewModel.fetchLinesStatus()

        // then
        verify(mockGetLinesStatusInteractor).execute()
        assert(statusViewModel.linesStatusLiveData.value
            == StatusState.Data(listOf(getExpectedLineStatusPresentation())))
    }
}
