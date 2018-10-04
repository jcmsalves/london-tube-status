package com.jcmsalves.londontubestatus.status

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import com.jcmsalves.londontubestatus.R
import com.jcmsalves.londontubestatus.R.id.recycler_view_lines_status
import com.jcmsalves.londontubestatus.R.id.srl_lines_status
import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation
import com.jcmsalves.londontubestatus.status.viewmodel.StatusState
import com.jcmsalves.londontubestatus.status.viewmodel.StatusViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class StatusActivity : AppCompatActivity() {

    private val statusAdapter: LinesStatusAdapter by inject()
    private val statusViewModel: StatusViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_lines_status.layoutManager = LinearLayoutManager(this)
        recycler_view_lines_status.adapter = statusAdapter

        val itemDecor = DividerItemDecoration(this, VERTICAL)
        recycler_view_lines_status.addItemDecoration(itemDecor)

        srl_lines_status.setOnRefreshListener { statusViewModel.fetchLinesStatus() }

        statusViewModel.linesStatusLiveData.observe(this, Observer {
            when(it) {
                is StatusState.Error -> showError()
                is StatusState.Loading -> showLoading()
                is StatusState.Data -> showLinesStatus(it.linesStatus)
            }
        })

        statusViewModel.fetchLinesStatus()
    }

    private fun showLoading() {
        srl_lines_status.isRefreshing = true
    }

    private fun showLinesStatus(linesStatus: List<LineStatusPresentation>) {
        srl_lines_status.isRefreshing = false
        statusAdapter.setLinesStatus(linesStatus)
    }

    private fun showError() {
        srl_lines_status.isRefreshing = false
        Snackbar.make(activity_main, R.string.error_message, Snackbar.LENGTH_LONG).show()
    }
}
