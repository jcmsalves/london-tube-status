package com.jcmsalves.londontubestatus.status.model

import com.jcmsalves.domain.status.model.LineStatus
import com.jcmsalves.londontubestatus.R
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class LineStatusToLineStatusPresentationMapperTest {

    private val mapper = LineStatusToLineStatusPresentationMapper()

    @Test
    fun shouldMapLineStatusModelToLineStatus() {
        // given
        val lineStatus = getLineStatus()
        val expectedLineStatusPresentation = getExpectedLineStatusPresentation()

        // when
        val mappingResult = mapper.map(lineStatus)

        // then
        SoftAssertions().apply {
            assertThat(mappingResult.id)
                .isEqualTo(expectedLineStatusPresentation.id)
            assertThat(mappingResult.name)
                .isEqualTo(expectedLineStatusPresentation.name)
            assertThat(mappingResult.severityLevel)
                .isEqualTo(expectedLineStatusPresentation.severityLevel)
            assertThat(mappingResult.severityLevelDescription)
                .isEqualTo(expectedLineStatusPresentation.severityLevelDescription)
            assertThat(mappingResult.colourResourceId)
                .isEqualTo(expectedLineStatusPresentation.colourResourceId)
            assertThat(mappingResult.badgeResourceId)
                .isEqualTo(expectedLineStatusPresentation.badgeResourceId)
        }.assertAll()
    }

    private fun getLineStatus(): LineStatus {
        return LineStatus(
            id = "central",
            name = "Central Line",
            severityLevel = "minor",
            severityLevelDescription = "Minor Delays"
        )
    }

    private fun getExpectedLineStatusPresentation(): LineStatusPresentation {
        return LineStatusPresentation(
            id = "central",
            name = "Central Line",
            severityLevel = "minor",
            severityLevelDescription = "Minor Delays",
            colourResourceId = R.color.colorOrange,
            badgeResourceId = R.drawable.ic_central
        )
    }
}
