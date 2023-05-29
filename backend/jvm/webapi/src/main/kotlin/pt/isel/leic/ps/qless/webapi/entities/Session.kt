package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

/**
 * 
 * @param token 
 */
@Entity
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("token", required = true) val sessionId: UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("token", required = true) val userId: UUID
) {

}

