package pt.isel.leic.ps.qless.webapi.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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

