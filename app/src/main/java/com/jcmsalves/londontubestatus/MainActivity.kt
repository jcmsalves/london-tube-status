package com.jcmsalves.londontubestatus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jcmsalves.domain.status.GetLinesStatusInteractor
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getLinesStatusInteractor: GetLinesStatusInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).applicationComponent.inject(this)

        getLinesStatusInteractor.execute()
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
