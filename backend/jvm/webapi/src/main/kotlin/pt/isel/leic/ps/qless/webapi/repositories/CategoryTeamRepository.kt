package pt.isel.leic.ps.qless.webapi.repositories

import org.hibernate.query.criteria.JpaSelection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.entities.CategoryTeam
import java.util.*

@Repository
interface CategoryTeamRepository :  JpaRepository<CategoryTeam,UUID>{


}