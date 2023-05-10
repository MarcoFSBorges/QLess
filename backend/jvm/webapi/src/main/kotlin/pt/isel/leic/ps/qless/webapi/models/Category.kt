package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param id 
 * @param name 
 * @param etc Estimated Time of Completion
 * @param priority 
 */
@Entity
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "Estimated Time of Completion")
    @get:JsonProperty("etc") val etc: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: Category.Priority? = null
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

