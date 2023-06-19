package pt.isel.leic.ps.qless.webapi

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.http.ResponseEntity
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.exceptions.CategoriesException
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository
import pt.isel.leic.ps.qless.webapi.services.CategoriesApiService
import java.lang.IllegalArgumentException
import java.util.*

@ExtendWith(MockitoExtension::class)
class CategoriesApiServiceTests {

    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @InjectMocks
    private lateinit var categoriesApiService: CategoriesApiService



    @Test
    fun createCategorySimpleTest(){
        // Arrange
        val categoryId = UUID.randomUUID()
        val categoryPost = CategoryPost("New Category", 1,CategoryPost.Priority.MEDIUM)
        val createdCategory = Category(categoryId, categoryPost.name, categoryPost.eta, Category.Priority.MEDIUM)

        Mockito.`when`(categoryRepository.save(any()))
            .thenReturn(createdCategory)

        // Act
        val response = categoriesApiService.createCategory(categoryPost)

        // Assert
        assertEquals(categoryId, response!!.categoryId)
        assertEquals(categoryPost.name, response!!.name)
        assertEquals(categoryPost.eta, response!!.eta)
        assertEquals(categoryPost.priority.value, response!!.priority!!.value)


    }

    @Test
    fun createCategoryEmptyNameTest(){
        // Arrange
        val categoryId = UUID.randomUUID()
        val categoryPost = CategoryPost("", 1,CategoryPost.Priority.MEDIUM)

        // Assert
        assertThrows<CategoriesException> {
            //Act
            categoriesApiService.createCategory(categoryPost)
        }



    }

    @Test
    fun createCategoryIllegalArgumentExceptionTest(){
        // Arrange
        val categoryPost = CategoryPost("New Category", 1,CategoryPost.Priority.MEDIUM)

        Mockito.`when`(categoryRepository.save(any()))
            .thenThrow(IllegalArgumentException())

        //Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.createCategory(categoryPost)
        }
    }

    @Test
    fun createCategoryOptimisticLockingFailureExceptionTest(){
        // Arrange
        val categoryPost = CategoryPost("New Category", 1,CategoryPost.Priority.MEDIUM)

        Mockito.`when`(categoryRepository.save(any()))
            .thenThrow(OptimisticLockingFailureException(""))

        //Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.createCategory(categoryPost)
        }
    }


}