package com.jcmsalves.londontubestatus.status

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import com.jcmsalves.londontubestatus.App
import com.jcmsalves.londontubestatus.R
import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation
import com.jcmsalves.londontubestatus.status.presenter.StatusPresenter
import com.jcmsalves.londontubestatus.status.view.StatusView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class StatusActivity : AppCompatActivity(), StatusView {

    @Inject
    lateinit var statusPresenter: StatusPresenter

    @Inject
    lateinit var statusAdapter: LinesStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).applicationComponent.inject(this)

        statusPresenter.attachView(this)
        recycler_view_lines_status.layoutManager = LinearLayoutManager(this)
        recycler_view_lines_status.adapter = statusAdapter

        val itemDecor = DividerItemDecoration(this, VERTICAL)
        recycler_view_lines_status.addItemDecoration(itemDecor)

        srl_lines_status.setOnRefreshListener { statusPresenter.fetchLinesStatus() }
    }

    override fun showLoading(loading: Boolean) {
        srl_lines_status.isRefreshing = loading
    }

    override fun showLinesStatus(linesStatus: List<LineStatusPresentation>) {
        statusAdapter.setLinesStatus(linesStatus)
    }

    override fun showError() {
        Snackbar.make(activity_main, R.string.error_message, Snackbar.LENGTH_LONG).show()
    }
}
