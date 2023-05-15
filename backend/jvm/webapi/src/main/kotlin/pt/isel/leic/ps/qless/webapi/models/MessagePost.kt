package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
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

