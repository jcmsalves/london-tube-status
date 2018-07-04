package com.jcmsalves.londontubestatus.status.model

data class LineStatusPresentation(
    val id: String,
    val name: String,
    val severityLevel: String,
    val severityLevelDescription: String,
    val colourResourceId: Int,
    val badgeResourceId: Int
)