package pt.isel.leic.ps.qless.webapi

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.data.repository.findByIdOrNull
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.exceptions.CategoriesException
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository
import pt.isel.leic.ps.qless.webapi.repositories.CategoryTeamRepository
import pt.isel.leic.ps.qless.webapi.services.CategoriesApiService
import java.util.*

@ExtendWith(MockitoExtension::class)
class CategoriesApiServiceTests {

    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @Mock
    private lateinit var categoryTeamRepository: CategoryTeamRepository

    @InjectMocks
    private lateinit var categoriesApiService: CategoriesApiService



    @Test
    fun createCategorySimpleTest(){
        // Arrange
        val categoryId = UUID.randomUUID()
        val categoryPost = CategoryPost("New Category", 1,CategoryPost.Priority.MEDIUM)
        val createdCategory = Category(categoryId, categoryPost.name, categoryPost.eta, Category.Priority.MEDIUM)

        `when`(categoryRepository.save(any()))
            .thenReturn(createdCategory)

        // Act
        val response = categoriesApiService.createCategory(categoryPost)

        // Assert
        assertEquals(categoryId, response!!.categoryId)
        assertEquals(categoryPost.name, response.name)
        assertEquals(categoryPost.eta, response.eta)
        assertEquals(categoryPost.priority.value, response.priority!!.value)


    }

    @Test
    fun createCategoryEmptyNameTest(){
        // Arrange
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
    @Test
    fun getAllCategoriesTest(){
        //Arrange
        val categories = mutableListOf<Category>()
        val cat1 = buildNewCategory(UUID.randomUUID())
        val cat2 = buildNewCategory(UUID.randomUUID())
        val cat3 = buildNewCategory(UUID.randomUUID())
        categories.add(cat1)
        categories.add(cat2)
        categories.add(cat3)

        `when`(categoryRepository.findAll()).thenReturn(categories)

        //Act
        val response = categoriesApiService.getAllCategories()

        //Assert
        assertEquals(categories.size, response!!.size)
        assertCategoryEquals(categories[0], response[0])
        assertCategoryEquals(categories[1], response[1])
        assertCategoryEquals(categories[2], response[2])

    }

    @Test
    fun getAllCategoriesExceptionTest(){
        //Arrange
        `when`(categoryRepository.findAll()).thenThrow(DataIntegrityViolationException(""))

        //Assert
        assertThrows<CategoriesException> {
            //Act
            categoriesApiService.getAllCategories()
        }


    }

    @Test
    fun deleteCategoryByIdSimpleTest(){
        //Arrange
        val uuid = UUID.randomUUID()
        `when`(categoryTeamRepository.existsById(any())).thenReturn(true)
        doNothing().`when`(categoryTeamRepository).deleteById(any())
        doNothing().`when`(categoryRepository).deleteById(any())

        //Assert
        assertDoesNotThrow {
            //Act
            categoriesApiService.deleteCategoryById(uuid)
        }
    }

    @Test
    fun deleteCategoryByIdDoesNotExistCategoryTeamTest(){
        //Arrange
        val uuid = UUID.randomUUID()
        `when`(categoryTeamRepository.existsById(any())).thenReturn(false)
        doNothing().`when`(categoryRepository).deleteById(any())

        //Assert
        assertDoesNotThrow {
            //Act
            categoriesApiService.deleteCategoryById(uuid)
        }
    }

    @Test
    fun deleteCategoryByIdCategoryTeamExceptionTest(){
        //Arrange
        val uuid = UUID.randomUUID()
        `when`(categoryTeamRepository.existsById(any())).thenReturn(false)
        `when`(categoryRepository.deleteById(any())).thenThrow(IllegalArgumentException())

        //Assert
        assertThrows<CategoriesException> {
            //Act
            categoriesApiService.deleteCategoryById(uuid)
        }
    }

    @Test
    fun deleteCategoryByIdCategoryExceptionTest(){
        //Arrange
        val uuid = UUID.randomUUID()
        `when`(categoryTeamRepository.existsById(any())).thenReturn(true)
        `when`(categoryTeamRepository.deleteById(any())).thenThrow(IllegalArgumentException())

        //Assert
        assertThrows<CategoriesException> {
            //Act
            categoriesApiService.deleteCategoryById(uuid)
        }
    }

    @Test
    fun getCategoryByIdSimpleTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val category: Category = buildNewCategory(categoryId)
        doReturn(Optional.of(category)).`when`(categoryRepository).findById(categoryId)

        // Act
        val result = categoriesApiService.getCategoryById(categoryId)

        // Assert
        assertEquals(category, result)
    }

    @Test
    fun getCategoryByIdNonExistingCategoryTest() {
        // Arrange
        val categoryId = UUID.randomUUID()

        `when`(categoryRepository.findById(any())).thenReturn(null)

        // Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.getCategoryById(categoryId)
        }
    }

    @Test
    fun getCategoryByIdExceptionTest() {
        // Arrange
        val categoryId = UUID.randomUUID()

        `when`(categoryRepository.findById(any())).thenThrow(RuntimeException())

        // Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.getCategoryById(categoryId)
        }
    }
    @Test
    fun updateCategoryByIdSimpleTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val updatedCategory = buildNewCategory(categoryId)
        val category = buildNewCategory(categoryId, Category.Priority.HIGH)

        `when`(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category))
        `when`(categoryRepository.save(updatedCategory)).thenReturn(updatedCategory)

        // Act
        val result = categoriesApiService.updateCategoryById(categoryId, updatedCategory)

        // Assert
        assertEquals(updatedCategory, result)
    }

    @Test
    fun updateCategoryByIdNonExistingCategoryTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val updatedCategory = buildNewCategory(categoryId)

        `when`(categoryRepository.findById(categoryId)).thenReturn(null)

        // Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.updateCategoryById(categoryId, updatedCategory)
        }
    }

    @Test
    fun updateCategoryByIdExceptionTest() {
        // Arrange
        val categoryId = UUID.randomUUID()
        val updatedCategory = buildNewCategory(categoryId)
        val category = buildNewCategory(categoryId, Category.Priority.HIGH)

        `when`(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category))
        `when`(categoryRepository.save(updatedCategory)).thenThrow(RuntimeException())

        // Assert
        assertThrows<CategoriesException> {
            // Act
            categoriesApiService.updateCategoryById(categoryId, updatedCategory)
        }
    }

    private fun assertCategoryEquals(expected: Category, actual: Category) {
        // Assert
        assertEquals(expected.categoryId, actual.categoryId)
        assertEquals(expected.name, actual.name)
        assertEquals(expected.eta, actual.eta)
        assertEquals(expected.priority!!.value, actual.priority!!.value)
    }
    private fun buildNewCategory(id: UUID, priority: Category.Priority = Category.Priority.MEDIUM):Category {return Category(id,"New Category", 1,Category.Priority.MEDIUM)}

}