package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.User
import java.util.*

@Repository
interface UserRepository :  JpaRepository<User,UUID>{


}