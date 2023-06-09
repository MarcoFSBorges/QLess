package pt.isel.leic.ps.qless.webapi.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.exceptions.CategoriesException
import pt.isel.leic.ps.qless.webapi.exceptions.TeamsException
import pt.isel.leic.ps.qless.webapi.models.CategoryPost
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository
import java.util.*

@Service
class CategoriesApiService(
        private val categoryRepository: CategoryRepository,
) {
    fun createCategory(categoryPost: CategoryPost): Category? {
        try {
            return categoryRepository.save(categoryPost.toCategory())
        } catch (exception: Exception) {
            throw CategoriesException("Error saving category", HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    fun deleteCategoryById(categoryId: UUID): Unit {
        //TODO delete row on team category as well to remove category from team
        try {
            categoryRepository.deleteById(categoryId)
        }catch (exception: Exception){
            throw CategoriesException("Error deleting category", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getAllCategories(): List<Category>? {
        try {
            return categoryRepository.findAll()
        }catch (exception: Exception){
            throw CategoriesException("Error getting categories", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getCategoryById(categoryId: UUID): Category? {
        try {
            val category = categoryRepository.findByIdOrNull(categoryId)
            if(category != null)
                return category
            else
                throw CategoriesException("Category Id does not exist", HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            throw CategoriesException("Error getting categories", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun updateCategoryById(categoryId: UUID, category: Category): Category? {
        try {
            val savedCategory = categoryRepository.findByIdOrNull(categoryId)
            if(savedCategory != null)
                return categoryRepository.save(category)
            else
                throw CategoriesException("Category Id does not exist", HttpStatus.NOT_FOUND)
        }catch (exception: Exception){
            throw CategoriesException("Error saving category", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}