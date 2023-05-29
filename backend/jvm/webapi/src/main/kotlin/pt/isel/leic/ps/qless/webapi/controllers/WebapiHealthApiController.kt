package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class WebapiHealthApiController() {

    @Operation(
        summary = "Route with the porpuse of supplying Render with current time",
        operationId = "webApiHealth",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "Success getting time", content = [Content(schema = Schema(implementation = kotlin.String::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/webapi-health"],
        produces = ["application/json"]
    )
    fun webApiHealth(): ResponseEntity<String> {
        return ResponseEntity.ok( System.currentTimeMillis().toString())
    }
}
