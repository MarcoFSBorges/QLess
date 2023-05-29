package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.User

/**
 * 
 * @param username 
 * @param fname 
 * @param lname 
 * @param email 
 * @param password 
 * @param role 
 */
data class UserPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("username") val username: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("fname") val fname: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lname") val lname: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("email") val email: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("password") val password: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("role") val role: UserPost.Role = Role.uSER
) {
    fun toUser(): User {
        return User(this.email,password,null, username, fname, lname)
    }

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

