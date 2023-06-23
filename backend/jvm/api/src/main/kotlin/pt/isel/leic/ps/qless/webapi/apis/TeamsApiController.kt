package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Team
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class TeamsApiController() {

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
    fun createTeam(@Parameter(description = "Team object to be created") @Valid @RequestBody(required = false) teamPost: TeamPost?): ResponseEntity<Team> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
    fun deleteTeamById(@Parameter(description = "ID of team to retrieve", required = true) @PathVariable("teamId") teamId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
    fun getAllTeams(): ResponseEntity<List<Team>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
    fun getTeamById(@Parameter(description = "ID of team to retrieve", required = true) @PathVariable("teamId") teamId: java.util.UUID): ResponseEntity<Team> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
    fun updateTeamById(@Parameter(description = "ID of team to retrieve", required = true) @PathVariable("teamId") teamId: java.util.UUID,@Parameter(description = "Team object to be updated") @Valid @RequestBody(required = false) team: Team?): ResponseEntity<Team> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
