package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.Session
import java.util.*

@Repository
interface SessionRepository :  JpaRepository<Session,UUID>{

}