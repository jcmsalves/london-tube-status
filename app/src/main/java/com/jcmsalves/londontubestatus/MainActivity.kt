package com.jcmsalves.londontubestatus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jcmsalves.domain.status.StatusRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var statusRepository: StatusRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).applicationComponent.inject(this)

        statusRepository.getLinesStatus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { linesStatus ->
                    Toast.makeText(applicationContext,
                        linesStatus.toString(), Toast.LENGTH_LONG).show()
                },
                { throwable: Throwable? ->
                    Toast.makeText(applicationContext,
                        throwable?.message, Toast.LENGTH_LONG).show()
                })
    }
}
