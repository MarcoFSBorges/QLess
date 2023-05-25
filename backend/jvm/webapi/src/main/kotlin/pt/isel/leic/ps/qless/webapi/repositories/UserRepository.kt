package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.models.Ticket
import pt.isel.leic.ps.qless.webapi.models.User
import java.util.*

@Repository
interface UserRepository :  JpaRepository<User,UUID>{


}