package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository

@Service
class TeamsApiService(
        private val categoryRepository: CategoryRepository,
        ) {



}