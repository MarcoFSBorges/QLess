package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.Team

/**
 * 
 * @param name 
 */
data class TeamPost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null
) {
    fun toTeam(): Team {
        return Team(null, name)
    }

}

