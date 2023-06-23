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
 * @param ticketId 
 * @param openedBy 
 * @param categoryId 
 * @param stateId 
 * @param createDate 
 * @param treatedBy 
 * @param updateDate 
 * @param solvedDate 
 */
data class Ticket(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("openedBy", required = true) val openedBy: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("categoryId", required = true) val categoryId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("stateId", required = true) val stateId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("create_date", required = true) val createDate: java.time.OffsetDateTime,

    @Schema(example = "null", description = "")
    @get:JsonProperty("treatedBy") val treatedBy: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("update_date") val updateDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("solved_date") val solvedDate: java.time.OffsetDateTime? = null
) {

}

