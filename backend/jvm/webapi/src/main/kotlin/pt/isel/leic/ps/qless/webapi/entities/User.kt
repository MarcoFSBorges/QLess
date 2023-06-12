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
@Table(name = "qless_user")
data class User(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("email", required = true) val email: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("password", required = true) val password: kotlin.String,

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("userId") val userId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @Column(unique = true)
    @get:JsonProperty("username") val username: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("fname") val fname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lname") val lname: kotlin.String? = null,

) {

    /**
    * 
    * Values: USER,EMPLOYEE,ADMIN
    */
    enum class Role(val value: kotlin.String) {

        @JsonProperty("USER") USER("USER"),
        @JsonProperty("EMPLOYEE") EMPLOYEE("EMPLOYEE"),
        @JsonProperty("ADMIN") ADMIN("ADMIN")
    }

}

