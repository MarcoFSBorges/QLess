package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.models.User
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class SignupApiController() {

    @Operation(
        summary = "Create a new user",
        operationId = "createUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "201", description = "Created", content = [Content(schema = Schema(implementation = User::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/signup"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createUser(@Parameter(description = "User object to be created") @Valid @RequestBody(required = false) user: User?): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
