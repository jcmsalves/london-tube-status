package com.jcmsalves.domain.status.model

data class LineStatus(
    val id: String,
    val name: String,
    val severityLevel: String,
    val severityLevelDescription: String
)