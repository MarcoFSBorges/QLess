package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
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
@Table(name = "user_role")
data class UserRole(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("userId") val userId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("roleId") val roleId: java.util.UUID? = null,

)

