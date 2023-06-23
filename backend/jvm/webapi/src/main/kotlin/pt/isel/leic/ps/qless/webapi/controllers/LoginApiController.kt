package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.models.Credentials
import pt.isel.leic.ps.qless.webapi.models.Token
import pt.isel.leic.ps.qless.webapi.services.CookieService
import pt.isel.leic.ps.qless.webapi.services.LoginApiService
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class LoginApiController(private val loginApiService: LoginApiService, private val cookieService: CookieService) {

    @Operation(
        summary = "Authenticate user and get token",
        operationId = "loginUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Token::class))]) ]
    )

    @CrossOrigin(origins = ["http://localhost:5173"], methods = [RequestMethod.GET, RequestMethod.POST], allowCredentials = "true")
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/login"],
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun loginUser(@Parameter(description = "User credentials") @Valid @RequestBody(required = false) credentials: Credentials?): ResponseEntity<String> {
        return ResponseEntity
            .ok()
            .body(loginApiService.login(credentials))
    }
}
