package com.jcmsalves.data.status.model

import com.jcmsalves.data.status.getExpectedLineStatus
import com.jcmsalves.data.status.getLineStatusModel
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class LineStatusModelToLineStatusMapperTest {

    private val mapper = LineStatusModelToLineStatusMapper()

    @Test
    fun shouldMapLineStatusModelToLineStatus() {
        // given
        val lineStatusModel = getLineStatusModel()
        val expectedLineStatus = getExpectedLineStatus()

        // when
        val mappingResult = mapper.map(lineStatusModel)

        // then
        SoftAssertions().apply {
            assertThat(mappingResult.id).isEqualTo(expectedLineStatus.id)
            assertThat(mappingResult.name).isEqualTo(expectedLineStatus.name)
            assertThat(mappingResult.severityLevel).isEqualTo(expectedLineStatus.severityLevel)
            assertThat(mappingResult.severityLevelDescription).isEqualTo(expectedLineStatus.severityLevelDescription)
        }.assertAll()
    }
}
