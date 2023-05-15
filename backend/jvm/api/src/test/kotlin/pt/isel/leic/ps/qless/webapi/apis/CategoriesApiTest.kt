package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Category
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class CategoriesApiTest {

    private val api: CategoriesApiController = CategoriesApiController()

    /**
     * To test CategoriesApiController.createCategory
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createCategoryTest() {
        val response: ResponseEntity<CategoryPost> = api.createCategory()

        // TODO: test validations
    }

    /**
     * To test CategoriesApiController.deleteCategoryById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteCategoryByIdTest() {
        val categoryId: java.util.UUID = TODO()
        val response: ResponseEntity<Unit> = api.deleteCategoryById(categoryId)

        // TODO: test validations
    }

    /**
     * To test CategoriesApiController.getAllCategories
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getAllCategoriesTest() {
        val response: ResponseEntity<List<Category>> = api.getAllCategories()

        // TODO: test validations
    }

    /**
     * To test CategoriesApiController.getCategoryById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getCategoryByIdTest() {
        val categoryId: java.util.UUID = TODO()
        val response: ResponseEntity<Category> = api.getCategoryById(categoryId)

        // TODO: test validations
    }

    /**
     * To test CategoriesApiController.updateCategoryById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun updateCategoryByIdTest() {
        val categoryId: java.util.UUID = TODO()
        val category: Category? = TODO()
        val response: ResponseEntity<Category> = api.updateCategoryById(categoryId, category)

        // TODO: test validations
    }
}
