package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param name 
 * @param etc Estimated Time of Completion
 * @param priority 
 */
data class CategoryPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "Estimated Time of Completion")
    @get:JsonProperty("etc") val etc: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: CategoryPost.Priority? = null
) {

    /**
    * 
    * Values: uERGENT,hIGH,mEDIUM,lOW
    */
    enum class Priority(val value: kotlin.String) {

        @JsonProperty("UERGENT") uERGENT("UERGENT"),
        @JsonProperty("HIGH") hIGH("HIGH"),
        @JsonProperty("MEDIUM") mEDIUM("MEDIUM"),
        @JsonProperty("LOW") lOW("LOW")
    }

}

