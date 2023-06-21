package pt.isel.leic.ps.qless.webapi

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import pt.isel.leic.ps.qless.webapi.apis.CategoriesApiController
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.services.CategoriesApiService
import java.util.*

@ExtendWith(MockitoExtension::class)
class CategoriesApiControllerTests {

    @Mock
    private lateinit var categoriesApiService: CategoriesApiService

    @InjectMocks
    private lateinit var categoriesApiController: CategoriesApiController

    @Test
    fun createCategoryTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val categoryPost = CategoryPost("New Category", 1,CategoryPost.Priority.MEDIUM)

        val createdCategory = Category(categoryId, categoryPost.name)
        val expectedResponse = ResponseEntity.ok(createdCategory)

        Mockito.`when`(categoriesApiService.createCategory(categoryPost))
            .thenReturn(createdCategory)

        // Act
        val response = categoriesApiController.createCategory(categoryPost)

        // Assert
        assertResponseEquals(expectedResponse, response)
    }



    @Test
    fun deleteCategoryByIdTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val expectedResponse = ResponseEntity<Unit>(Unit,HttpStatus.NO_CONTENT)


        Mockito.doNothing().`when`(categoriesApiService).deleteCategoryById(categoryId)

        // Act
        val response = categoriesApiController.deleteCategoryById(categoryId)

        // Assert
        assertResponseEquals(expectedResponse, response)
    }

    @Test
    fun getAllCategoriesTest() {
        // Arrange
        val categories = listOf(
            Category(UUID.randomUUID(), "Category 1"),
            Category(UUID.randomUUID(), "Category 2")
        )

        val expectedResponse = ResponseEntity.ok(categories)

        Mockito.`when`(categoriesApiService.getAllCategories())
            .thenReturn(categories)

        // Act
        val response = categoriesApiController.getAllCategories()

        // Assert
        assertResponseEquals(expectedResponse, response)
    }

    @Test
    fun getCategoryByIdTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val category = Category(categoryId, "Category 1")
        val expectedResponse = ResponseEntity.ok(category)

        Mockito.`when`(categoriesApiService.getCategoryById(categoryId))
            .thenReturn(category)

        // Act
        val response = categoriesApiController.getCategoryById(categoryId)

        // Assert
        assertResponseEquals(expectedResponse, response)
    }

    @Test
    fun updateCategoryByIdTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val updatedCategory = Category(categoryId,"Updated Category")

            val expectedResponse = ResponseEntity.ok(updatedCategory)

        Mockito.`when`(categoriesApiService.updateCategoryById(categoryId, updatedCategory))
            .thenReturn(updatedCategory)

        // Act
        val response = categoriesApiController.updateCategoryById(categoryId, updatedCategory)

        // Assert
        assertResponseEquals(expectedResponse, response)
    }

    // Helper function to compare the responses
    private fun <T> assertResponseEquals(expectedResponse: ResponseEntity<T>, actualResponse: ResponseEntity<T>) {
        assertEquals(expectedResponse.statusCode, actualResponse.statusCode)
        assertEquals(expectedResponse.body, actualResponse.body)
    }

    // Helper function to set up a mock request with headers
    private fun mockHttpServletRequest():
            HttpServletRequest {
        val request = MockHttpServletRequest()
        RequestContextHolder.setRequestAttributes(ServletRequestAttributes(request))
        return request
    }

    // Helper function to set up a mock response
    private fun mockHttpServletResponse(): HttpServletResponse {
        return MockHttpServletResponse()
    }
}

