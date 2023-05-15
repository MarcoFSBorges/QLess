package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.models.Ticket
import java.util.*

@Repository
interface TicketRepository :  JpaRepository<Ticket,UUID>{

}