package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.entities.Team
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.services.TeamsApiService
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class TeamsApiController(private val teamsApiService: TeamsApiService) {

    @Operation(
            summary = "",
            operationId = "createTeam",
            description = """Add a new team""",
            responses = [
                ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Team::class))]) ],
            security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/teams"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createTeam(
            @Parameter(description = "Team object to be created")
            @Valid
            @RequestBody(required = false)
            teamPost: TeamPost?): ResponseEntity<Team> {
        return ResponseEntity.ok(teamsApiService.createTeam(teamPost!!))
    }

    @Operation(
        summary = "",
        operationId = "deleteTeamById",
        description = """Delete Team by Id""",
        responses = [
            ApiResponse(responseCode = "204", description = "No Content") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/teams/{teamId}"]
    )
    fun deleteTeamById(
            @Parameter(description = "ID of team to retrieve", required = true)
            @PathVariable("teamId") teamId: java.util.UUID):
            ResponseEntity<Unit> {
        return ResponseEntity.ok(teamsApiService.deleteTeamById(teamId))
    }

    @Operation(
        summary = "",
        operationId = "getAllTeams",
        description = """Get all teams""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Team::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/teams"],
        produces = ["application/json"]
    )
    fun getAllTeams(
            @CookieValue("qless-cookie")
            qlessCookie: String
        ): ResponseEntity<List<Team>> {
        return ResponseEntity.ok(teamsApiService.getAllTeams())
    }

    @Operation(
        summary = "",
        operationId = "getTeamById",
        description = """Get Team by Id""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Team::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/teams/{teamId}"],
        produces = ["application/json"]
    )
    fun getTeamById(
            @Parameter(description = "ID of team to retrieve", required = true)
            @PathVariable("teamId")
            teamId: java.util.UUID): ResponseEntity<Team> {
        return ResponseEntity.ok(teamsApiService.getTeamById(teamId))
    }

    @Operation(
        summary = "",
        operationId = "updateTeamById",
        description = """Update Team by Id""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Team::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/teams/{teamId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTeamById(
            @Parameter(description = "ID of team to retrieve", required = true)
            @PathVariable("teamId")
            teamId: java.util.UUID,
            @Parameter(description = "Team object to be updated")
            @Valid
            @RequestBody(required = false)
            team: Team?,
            @CookieValue("qless-cookie")
            qlessCookie: String
        ): ResponseEntity<Team> {
        return ResponseEntity.ok(teamsApiService.updateTeamById(teamId, team!!))
    }
}
