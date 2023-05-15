package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository

@Service
class CategoriesApiService(
        private val categoryRepository: CategoryRepository,
        ) {


}