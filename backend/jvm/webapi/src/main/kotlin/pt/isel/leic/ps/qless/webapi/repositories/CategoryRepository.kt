package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.Category
import java.util.*

@Repository
interface CategoryRepository :  JpaRepository<Category,UUID>{

    @Query("SELECT c from Category c where c.name = ?1")
    fun getCategoryByName(categoryName: String): Category

}