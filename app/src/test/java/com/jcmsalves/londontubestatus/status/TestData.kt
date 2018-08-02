package com.jcmsalves.londontubestatus.status

import com.jcmsalves.domain.status.model.LineStatus
import com.jcmsalves.londontubestatus.R
import com.jcmsalves.londontubestatus.status.model.LineStatusPresentation

fun getLineStatus(): LineStatus {
    return LineStatus(
        id = "central",
        name = "Central Line",
        severityLevel = "minor",
        severityLevelDescription = "Minor Delays"
    )
}

fun getExpectedLineStatusPresentation(): LineStatusPresentation {
    return LineStatusPresentation(
        id = "central",
        name = "Central Line",
        severityLevel = "minor",
        severityLevelDescription = "Minor Delays",
        colourResourceId = R.color.colorOrange,
        badgeResourceId = R.drawable.ic_central
    )
}
