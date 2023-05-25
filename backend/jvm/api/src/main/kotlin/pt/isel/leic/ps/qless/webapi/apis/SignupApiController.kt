package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.User
import pt.isel.leic.ps.qless.webapi.models.UserPost
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
    fun createUser(@Parameter(description = "User object to be created") @Valid @RequestBody(required = false) userPost: UserPost?): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
