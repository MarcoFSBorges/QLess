package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param email 
 * @param password 
 * @param id 
 * @param fname 
 * @param lname 
 * @param role 
 */
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("email", required = true) val email: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("password", required = true) val password: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("fname") val fname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lname") val lname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("role") val role: User.Role? = Role.User
) {

    /**
    * 
    * Values: uSER,eMPLOYEE,aDMIN
    */
    enum class Role(val value: kotlin.String) {

        @JsonProperty("USER") User("USER"),
        @JsonProperty("EMPLOYEE") Employee("EMPLOYEE"),
        @JsonProperty("ADMIN") Admin("ADMIN")
    }

}

