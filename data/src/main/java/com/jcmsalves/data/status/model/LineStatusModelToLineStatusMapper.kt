package com.jcmsalves.data.status.model

import com.jcmsalves.domain.Mapper
import com.jcmsalves.domain.status.model.LineStatus

class LineStatusModelToLineStatusMapper : Mapper<LineStatusModel, LineStatus> {

    override fun map(from: LineStatusModel): LineStatus {
        return LineStatus(
            id = from.id,
            name = from.name,
            severityLevel = mapSeverityLevel(from.statusModels[0].severityLevel),
            severityLevelDescription = from.statusModels[0].severityLevelDescription
        )
    }

    private fun mapSeverityLevel(severityLevel: Int): String =
        when (severityLevel) {
            10, 18, 19 -> "good"
            0, 4, 5, 9, 11, 12, 13, 14, 17 -> "minor"
            1, 2, 3, 6, 7, 8, 15, 16, 20 -> "severe"
            else -> "default"
        }
}
