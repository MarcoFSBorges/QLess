package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param name 
 * @param eta Estimated Time of Accomplishment
 * @param priority 
 */
data class CategoryPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "Estimated Time of Accomplishment")
    @get:JsonProperty("eta") val eta: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: CategoryPost.Priority? = null
) {

    /**
    * 
    * Values: uRGENT,hIGH,mEDIUM,lOW
    */
    enum class Priority(val value: kotlin.String) {

        @JsonProperty("URGENT") uRGENT("URGENT"),
        @JsonProperty("HIGH") hIGH("HIGH"),
        @JsonProperty("MEDIUM") mEDIUM("MEDIUM"),
        @JsonProperty("LOW") lOW("LOW")
    }

}

