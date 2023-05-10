package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.models.Ticket
import java.util.UUID

@Repository
interface TicketRepository :  CrudRepository<Ticket,UUID>{

}