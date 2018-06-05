package com.jcmsalves.data.status.model

import com.google.gson.annotations.SerializedName

data class LineStatus(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("lineStatuses")
    val statuses: List<Status>
)

data class Status(
    @SerializedName("statusSeverity")
    val severityLevel: String,
    @SerializedName("statusSeverityDescription")
    val severityLevelDescription: String
)