package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.jsonwebtoken.Header
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

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
    @get:JsonProperty("password", required = true) var password: kotlin.String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("userId") val userId: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("fname") val fname: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("lname") val lname: kotlin.String? = null,

   /* @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name ="openedBy", referencedColumnName = "userId" )
    @get:JsonProperty("tickets") val tickets: Set<Ticket>? = null,*/

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

    companion object {
        fun fromToken(header: Header<*>): User {
            return User(
                    userId = UUID.fromString(header["userId"] as String),
                    email = header["email"] as String,
                    fname = header["fname"] as String,
                    lname = header["lname"] as String
            )
        }
    }

}

