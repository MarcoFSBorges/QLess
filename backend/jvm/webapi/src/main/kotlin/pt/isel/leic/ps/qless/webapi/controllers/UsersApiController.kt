package pt.isel.leic.ps.qless.webapi.controllers

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.entities.Team
import pt.isel.leic.ps.qless.webapi.entities.User
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.services.TeamsApiService
import pt.isel.leic.ps.qless.webapi.services.UsersApiService
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class UsersApiController(private val usersApiService: UsersApiService) {

    @Operation(
            summary = "",
            operationId = "getUserByEmail",
            description = """Get User by Email""",
            responses = [
                ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = User::class))]) ]
    )

    @CrossOrigin(origins = ["http://localhost:5173"], methods = [RequestMethod.GET], allowCredentials = "true")
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/user/{email}"],
            produces = ["application/json"]
    )
    fun getUserByEmail(
            @Parameter(description = "Email of user to retrieve", required = true)
            @PathVariable("email")
            email: String): ResponseEntity<User> {
        return ResponseEntity.ok(usersApiService.getUserByEmail(email))
    }


}
