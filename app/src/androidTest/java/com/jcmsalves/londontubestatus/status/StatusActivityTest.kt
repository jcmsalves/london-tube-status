package com.jcmsalves.londontubestatus.status

import android.support.test.rule.ActivityTestRule
import com.jcmsalves.londontubestatus.screens.StatusScreen
import org.junit.Rule
import org.junit.Test

class StatusActivityTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<StatusActivity>(StatusActivity::class.java)

    private val statusScreen = StatusScreen()

    @Test
    fun recyclerViewShouldBeDisplayedCorrectly() {
        statusScreen {
            recyclerView {
                isVisible()
                hasSize(11)
                firstChild<StatusScreen.StatusRecyclerItem> {
                    isVisible()
                    lineName { hasText("Bakerloo") }
                }
            }
        }
    }
}
