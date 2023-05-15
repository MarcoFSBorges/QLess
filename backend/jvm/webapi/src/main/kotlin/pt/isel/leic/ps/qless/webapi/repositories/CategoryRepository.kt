package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.models.Attachment
import pt.isel.leic.ps.qless.webapi.models.Category
import java.util.*

@Repository
interface CategoryRepository :  JpaRepository<Category,UUID>{

}