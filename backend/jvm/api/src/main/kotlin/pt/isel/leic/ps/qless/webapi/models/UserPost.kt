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
 * @param fname 
 * @param lname 
 * @param email 
 * @param password 
 * @param role 
 */
data class UserPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("fname") val fname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lname") val lname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("email") val email: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("password") val password: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("role") val role: UserPost.Role? = Role.uSER
) {

    /**
    * 
    * Values: uSER,eMPLOYEE,aDMIN
    */
    enum class Role(val value: kotlin.String) {

        @JsonProperty("USER") uSER("USER"),
        @JsonProperty("EMPLOYEE") eMPLOYEE("EMPLOYEE"),
        @JsonProperty("ADMIN") aDMIN("ADMIN")
    }

}

