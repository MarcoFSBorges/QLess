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
 * @param createDate 
 * @param content 
 * @param name 
 */
data class AttachmentPost(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("createDate", required = true) val createDate: java.time.OffsetDateTime,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("content", required = true) val content: kotlin.ByteArray,

    @get:Size(max=255)
    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null
) {

}

