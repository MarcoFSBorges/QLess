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
 * @param messageId 
 * @param ticketId 
 * @param content 
 * @param timeSent 
 * @param isEmployee 
 */
data class Message(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("messageId", required = true) val messageId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("content", required = true) val content: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("timeSent", required = true) val timeSent: java.time.OffsetDateTime,

    @Schema(example = "null", description = "")
    @get:JsonProperty("isEmployee") val isEmployee: kotlin.Boolean? = null
) {

}

