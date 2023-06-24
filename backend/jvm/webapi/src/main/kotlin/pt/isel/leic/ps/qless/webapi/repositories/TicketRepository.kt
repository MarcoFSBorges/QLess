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
    about the employee's (the one who assumed it) first and last name and the category name of the ticket */
    @Query("SELECT u.fname, u.lname, c.name\n" +
            "from Ticket t\n" +
            "join User u on t.openedBy = u.userId\n" +
            "join Category c on t.categoryId = c.categoryId\n" +
            "where t.openedBy = ?1")
    fun getAllTicketsByUser(userId: UUID) : List<Any?>
}