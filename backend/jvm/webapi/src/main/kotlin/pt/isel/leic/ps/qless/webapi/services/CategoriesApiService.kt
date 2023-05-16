package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.Category
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository
import java.util.*

@Service
class CategoriesApiService(
        private val categoryRepository: CategoryRepository,
        ) {
        fun createCategory(categoryPost: CategoryPost): Category? {
                TODO()
        }

        fun deleteCategoryById(categoryId: UUID): Unit? {
                TODO("Not yet implemented")
        }

        fun getAllCategories(): List<Category>? {
                return categoryRepository.findAll()
        }

        fun getCategoryById(categoryId: UUID): Category? {
                TODO("Not yet implemented")
        }

        fun updateCategoryById(categoryId: UUID, category: Category): Category? {
                TODO("Not yet implemented")
        }


}