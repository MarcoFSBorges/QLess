package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.services.CategoriesApiService
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class CategoriesApiController(private val categoriesApiService: CategoriesApiService) {

    @Operation(
            summary = "",
            operationId = "createCategory",
            description = """Add a new Category""",
            responses = [
                ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Category::class))]) ],
            security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/categories"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createCategory(
            @Parameter(description = "Team object to be updated")
            @Valid
            @RequestBody(required = false)
            categoryPost: CategoryPost?): ResponseEntity<Category> {
        return ResponseEntity.ok(categoriesApiService.createCategory(categoryPost!!))
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
    fun deleteCategoryById(
            @Parameter(description = "ID of category to retrieve", required = true)
            @PathVariable("categoryId")
            categoryId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity.ok(categoriesApiService.deleteCategoryById(categoryId))
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
        return ResponseEntity.ok(categoriesApiService.getAllCategories())
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
    fun getCategoryById(
            @Parameter(description = "ID of category to retrieve", required = true)
            @PathVariable("categoryId")
            categoryId: java.util.UUID): ResponseEntity<Category> {
        return ResponseEntity.ok(categoriesApiService.getCategoryById(categoryId))
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
    fun updateCategoryById(
            @Parameter(description = "ID of category to retrieve", required = true)
            @PathVariable("categoryId")
            categoryId: java.util.UUID,
            @Parameter(description = "Category object to be updated")
            @Valid
            @RequestBody(required = false)
            category: Category?): ResponseEntity<Category> {
        return ResponseEntity.ok(categoriesApiService.updateCategoryById(categoryId, category!!))
    }
}
