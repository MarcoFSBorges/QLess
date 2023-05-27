package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Attachment
import pt.isel.leic.ps.qless.webapi.entities.Message
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import pt.isel.leic.ps.qless.webapi.models.*
import pt.isel.leic.ps.qless.webapi.repositories.AttachmentRepository
import pt.isel.leic.ps.qless.webapi.repositories.MessageRepository
import pt.isel.leic.ps.qless.webapi.repositories.TicketRepository
import java.util.*
import kotlin.collections.HashSet

@Service
class TicketsApiService(
        private val ticketRepository: TicketRepository, 
        private val messageRepository : MessageRepository,
        private val attachmentRepository: AttachmentRepository
        ) {
    fun getAllTickets(): List<Ticket> {
        return ticketRepository.findAll();
    }

    fun createAttachment(ticketId: UUID, attachmentPost: AttachmentPost): Attachment? {
        TODO("Not yet implemented")
    }

    fun createTicket(ticketPost: TicketPost): Ticket? {
        var savedTicked = ticketRepository.save(ticketPost.toTicket())
        if(savedTicked.ticketId != null){
            val msg = Message.fromTicket(savedTicked, ticketPost.comment)
            val savedMessage = messageRepository.save(msg)
            var msgSet = HashSet<Message>()
            msgSet.add(savedMessage)
            savedTicked.messages = msgSet
        }
        return savedTicked
    }

    fun createTicketMessage(ticketId: UUID, messagePost: MessagePost): Message? {
        TODO("Not yet implemented")
    }

    fun deleteAttachmentById(ticketId: UUID, attachmentId: UUID): Unit? {
        TODO("Not yet implemented")
    }

    fun deleteTicketById(ticketId: UUID): Unit? {
        TODO("Not yet implemented")
    }

    fun deleteTicketMessageById(ticketId: UUID, messageId: UUID): Unit? {
        TODO("Not yet implemented")
    }

    fun getAttachmentById(ticketId: UUID, attachmentId: UUID): Attachment? {
        TODO("Not yet implemented")
    }

    fun getTicketById(ticketId: UUID): Ticket? {
        TODO("Not yet implemented")
    }

    fun getTicketMessageById(ticketId: UUID, messageId: UUID): Message? {
        TODO("Not yet implemented")
    }

    fun getTicketMessages(ticketId: UUID): List<Message>? {
        TODO("Not yet implemented")
    }

    fun updateAttachmentById(ticketId: UUID, attachmentId: UUID, attachment: Attachment): Attachment? {
        TODO("Not yet implemented")
    }

    fun updateTicketById(ticketId: UUID, ticket: Ticket): Ticket? {
        TODO("Not yet implemented")
    }

    fun updateTicketMessageById(ticketId: UUID, messageId: UUID, message: Message): Message? {
        TODO("Not yet implemented")
    }


}