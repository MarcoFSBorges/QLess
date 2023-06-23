package pt.isel.leic.ps.qless.webapi.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param comment 
 * @param createDate 
 * @param categoryId 
 * @param openedBy 
 */
data class TicketPost(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("comment", required = true) val comment: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("create_date", required = true) val createDate: java.time.OffsetDateTime,

    @Schema(example = "null", description = "")
    @get:JsonProperty("categoryId") val categoryId: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("openedBy") val openedBy: java.util.UUID? = null
) {

}

