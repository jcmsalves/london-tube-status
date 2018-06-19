package com.jcmsalves.data.status.model

import com.jcmsalves.domain.Mapper
import com.jcmsalves.domain.status.model.LineStatus

class LineStatusModelToLineStatusMapper : Mapper<LineStatusModel, LineStatus> {

    override fun map(from: LineStatusModel): LineStatus {
        return LineStatus(
            id = from.id,
            name = from.name,
            severityLevel = from.statusModels[0].severityLevel,
            severityLevelDescription = from.statusModels[0].severityLevelDescription
        )
    }
}
