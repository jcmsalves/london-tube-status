package com.jcmsalves.londontubestatus.status.presenter

import com.jcmsalves.domain.status.GetLinesStatusInteractor
import com.jcmsalves.londontubestatus.status.getExpectedLineStatusPresentation
import com.jcmsalves.londontubestatus.status.getLineStatus
import com.jcmsalves.londontubestatus.status.model.LineStatusToLineStatusPresentationMapper
import com.jcmsalves.londontubestatus.status.view.StatusView
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class StatusPresenterTest {

    private val mockGetLinesStatusInteractor = mock<GetLinesStatusInteractor>()
    private val mockStatusView = mock<StatusView>()
    private lateinit var statusPresenter: StatusPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        statusPresenter = StatusPresenter(
            mockGetLinesStatusInteractor,
            LineStatusToLineStatusPresentationMapper()
        )
    }

    @Test
    fun shouldTriggerShowErrorWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockGetLinesStatusInteractor.execute())
            .thenReturn(Observable.error(throwable))

        // when
        statusPresenter.attachView(mockStatusView)

        // then
        verify(mockStatusView).showLoading(true)
        verify(mockStatusView).showError()
        verify(mockStatusView).showLoading(false)
    }

    @Test
    fun shouldTriggerShowLinesStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockGetLinesStatusInteractor.execute())
            .thenReturn(Observable.just(listOf(getLineStatus())))

        // when
        statusPresenter.attachView(mockStatusView)

        // then
        verify(mockStatusView).showLoading(true)
        verify(mockStatusView).showLinesStatus(listOf(getExpectedLineStatusPresentation()))
        verify(mockStatusView).showLoading(false)
    }
}
