package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param categoryId 
 * @param name 
 * @param eta Estimated Time of Accomplishment
 * @param priority 
 */
@Entity
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("categoryId") val categoryId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "Estimated Time of Accomplishment")
    @get:JsonProperty("eta") val eta: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: Priority? = null
) {

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

