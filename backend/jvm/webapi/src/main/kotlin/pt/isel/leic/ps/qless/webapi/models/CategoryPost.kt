package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.Category

/**
 * 
 * @param name 
 * @param eta Estimated Time of Accomplishment
 * @param priority 
 */
data class CategoryPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String,

    @Schema(example = "null", description = "Estimated Time of Accomplishment")
    @get:JsonProperty("eta") val eta: kotlin.Int,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: CategoryPost.Priority
) {
    fun toCategory(): Category {
        return Category(null, name, eta, Category.Priority.valueOf(priority.value) )
    }

    /**
    * 
    * Values: uRGENT,hIGH,mEDIUM,lOW
    */
    enum class Priority(val value: kotlin.String) {

        @JsonProperty("URGENT") URGENT("URGENT"),
        @JsonProperty("HIGH") HIGH("HIGH"),
        @JsonProperty("MEDIUM") MEDIUM("MEDIUM"),
        @JsonProperty("LOW") LOW("LOW")
    }

}

