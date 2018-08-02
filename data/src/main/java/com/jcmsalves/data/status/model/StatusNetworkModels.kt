package com.jcmsalves.data.status.model

import com.google.gson.annotations.SerializedName

data class LineStatusModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("lineStatuses")
    val statusModels: List<StatusModel>
)

data class StatusModel(
    @SerializedName("statusSeverity")
    val severityLevel: Int,
    @SerializedName("statusSeverityDescription")
    val severityLevelDescription: String
)