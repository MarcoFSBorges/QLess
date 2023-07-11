package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import java.util.*

@Repository
interface TicketRepository :  JpaRepository<Ticket,UUID>{

    @Query("SELECT t from Ticket t where t.openedBy = ?1")
    fun getAllTicketsByUserId(userId: UUID) : List<Ticket?>


    /* This query, based on current User, returns all created tickets providing info
    about the employee's (the one who assumed it) first and last name, ticket category, state, and dates */
    @Query("SELECT u.fname, u.lname, c.name, s.name, t.createDate, t.updateDate, t.ticketId\n" +
            "from Ticket t\n" +
            "join User u on t.openedBy = u.userId\n" +
            "join Category c on t.categoryId = c.categoryId\n" +
            "join State s on t.stateId = s.stateId\n" +
            "where t.openedBy = ?1")
    fun getAllTicketsByUser(userId: UUID) : List<Any?>

    @Query("SELECT e.fname, e.lname, c.name, t.createDate, t.updateDate, s.name\n" +
            "from Ticket t\n" +
            "left outer join User e on t.treatedBy = e.userId\n" +
            "and t.treatedBy is not null\n" +
            "join Category c on t.categoryId = c.categoryId\n" +
            "join State s on t.stateId = s.stateId\n" +
            "where t.openedBy = ?1 and t.ticketId = ?2")
     fun getTicketDetailsForUser(userId: UUID, ticketId: UUID): Any?
}