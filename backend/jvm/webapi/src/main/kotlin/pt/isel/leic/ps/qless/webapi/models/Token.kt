package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param token 
 */
data class Token(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("token", required = true) val token: kotlin.String
) {

}

