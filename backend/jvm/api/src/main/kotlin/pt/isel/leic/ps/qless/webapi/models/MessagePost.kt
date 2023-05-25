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
 * @param sender 
 * @param content 
 */
data class MessagePost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("sender") val sender: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("content") val content: kotlin.String? = null
) {

}

