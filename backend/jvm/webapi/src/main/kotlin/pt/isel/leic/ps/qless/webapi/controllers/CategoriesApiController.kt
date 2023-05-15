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
import pt.isel.leic.ps.qless.webapi.models.Category
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class CategoriesApiController() {

    @Operation(
        summary = "",
        operationId = "createCategory",
        description = """Add a new Category""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CategoryPost::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/categories"],
        produces = ["application/json"]
    )
    fun createCategory(): ResponseEntity<CategoryPost> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "deleteCategoryById",
        description = """Delete Category by Id""",
        responses = [
            ApiResponse(responseCode = "204", description = "No Content") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/categories/{categoryId}"]
    )
    fun deleteCategoryById(@Parameter(description = "ID of category to retrieve", required = true) @PathVariable("categoryId") categoryId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "getAllCategories",
        description = """Get all Categories""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Category::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/categories"],
        produces = ["application/json"]
    )
    fun getAllCategories(): ResponseEntity<List<Category>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "getCategoryById",
        description = """Get Category by Id""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Category::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/categories/{categoryId}"],
        produces = ["application/json"]
    )
    fun getCategoryById(@Parameter(description = "ID of category to retrieve", required = true) @PathVariable("categoryId") categoryId: java.util.UUID): ResponseEntity<Category> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "updateCategoryById",
        description = """Update Category by Id""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Category::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/categories/{categoryId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateCategoryById(@Parameter(description = "ID of category to retrieve", required = true) @PathVariable("categoryId") categoryId: java.util.UUID,@Parameter(description = "Category object to be updated") @Valid @RequestBody(required = false) category: Category?): ResponseEntity<Category> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
