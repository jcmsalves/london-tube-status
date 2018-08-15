package com.jcmsalves.londontubestatus.screens

import android.view.View
import com.agoda.kakao.*
import com.jcmsalves.londontubestatus.R
import org.hamcrest.Matcher

class StatusScreen : Screen<StatusScreen>() {

    class StatusRecyclerItem(parent: Matcher<View>)
        : KRecyclerItem<StatusRecyclerItem>(parent) {

        val lineName: KTextView =
            KTextView(parent) { withId(R.id.text_view_line_name) }
    }

    val recyclerView = KRecyclerView(
        { withId(R.id.recycler_view_lines_status) },
        { itemType(::StatusRecyclerItem) })
}
