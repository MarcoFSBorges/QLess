package pt.isel.leic.ps.qless.webapi.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.entities.State
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.services.CategoriesApiService
import pt.isel.leic.ps.qless.webapi.services.StatesApiService
import javax.validation.Valid



class StatesApiController {
    @RestController
    @Validated
    @RequestMapping("\${api.base-path:}")
    class StatesApiController(private val statesApiService: StatesApiService) {

        @Operation(
                summary = "",
                operationId = "getState",
                description = """Get state""",
                responses = [
                    ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = State::class))])],
                security = [SecurityRequirement(name = "basicAuth")]
        )

        @CrossOrigin(origins = ["http://localhost:5173"], methods = [RequestMethod.GET], allowCredentials = "true")
        @RequestMapping(
                method = [RequestMethod.GET],
                value = ["/states"],
                produces = ["application/json"],
                consumes = ["application/json"]
        )
        fun getStateByName(
                @Parameter(description = "Name of the state to return")
                @Valid
                @RequestBody(required = false)
                @RequestParam("stateName") stateName: String): ResponseEntity<State> {
            return ResponseEntity.ok(statesApiService.getState(stateName))
        }
    }
}