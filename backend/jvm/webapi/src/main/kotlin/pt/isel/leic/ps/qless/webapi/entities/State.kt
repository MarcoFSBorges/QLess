package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * 
 * @param email 
 * @param password 
 * @param userId 
 * @param username 
 * @param fname 
 * @param lname 
 * @param role 
 */
@Entity
data class State(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @Column(name="state_id")
    @get:JsonProperty("stateId") val stateId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null,

)

