package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param teamId 
 * @param name 
 */
@Entity
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", description = "")
    @get:JsonProperty("roleId") val roleId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null
) {

}

