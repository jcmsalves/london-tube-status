package com.jcmsalves.londontubestatus.status.model

import com.jcmsalves.domain.Mapper
import com.jcmsalves.domain.status.model.LineStatus
import com.jcmsalves.londontubestatus.R

class LineStatusToLineStatusPresentationMapper : Mapper<LineStatus, LineStatusPresentation> {

    override fun map(from: LineStatus): LineStatusPresentation {
        return LineStatusPresentation(
            id = from.id,
            name = from.name,
            severityLevel = from.severityLevel,
            severityLevelDescription = from.severityLevelDescription,
            colourResourceId = mapSeverityColour(from.severityLevel),
            badgeResourceId = mapLineBadge(from.name)
        )
    }

    private fun mapSeverityColour(severityLevel: String): Int =
        when (severityLevel) {
            "good" -> R.color.colorGreen
            "minor" -> R.color.colorOrange
            "severe" -> R.color.colorRed
            else -> R.color.colorLightGrey
        }

    private fun mapLineBadge(lineId: String): Int =
        when (lineId) {

            "central" -> R.drawable.ic_central
            "piccadilly" -> R.drawable.ic_piccadilly
            "victoria" -> R.drawable.ic_victoria
            "northern" -> R.drawable.ic_northern
            "district" -> R.drawable.ic_district
            "circle" -> R.drawable.ic_circle
            "hammersmith-city" -> R.drawable.ic_hammersmith
            "metropolitan" -> R.drawable.ic_metropolitan
            "bakerloo" -> R.drawable.ic_bakerloo
            "waterloo-city" -> R.drawable.ic_waterloo
            "jubilee" -> R.drawable.ic_jubilee
            "overground" -> R.drawable.ic_overground
            else -> R.drawable.ic_tube
        }
}