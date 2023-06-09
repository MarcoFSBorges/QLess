package pt.isel.leic.ps.qless.webapi.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Attachment
import pt.isel.leic.ps.qless.webapi.entities.Message
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import pt.isel.leic.ps.qless.webapi.exceptions.TicketsException
import pt.isel.leic.ps.qless.webapi.models.AttachmentPost
import pt.isel.leic.ps.qless.webapi.models.MessagePost
import pt.isel.leic.ps.qless.webapi.models.TicketPost
import pt.isel.leic.ps.qless.webapi.repositories.AttachmentRepository
import pt.isel.leic.ps.qless.webapi.repositories.MessageRepository
import pt.isel.leic.ps.qless.webapi.repositories.TicketRepository
import java.util.*

private const val TICKET_ID_DOES_NOT_EXIST = "Ticket Id does not exist"
private const val ERROR_GETTING_TICKET = "Error getting ticket"

@Service
class TicketsApiService(
        private val ticketRepository: TicketRepository, 
        private val messageRepository : MessageRepository,
        private val attachmentRepository: AttachmentRepository
        ) {
    fun getAllTickets(): List<Ticket> {
        try {
            return ticketRepository.findAll()
        }catch (exception: Exception){
            throw TicketsException("Error getting tickets", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun createAttachment(ticketId: UUID, attachmentPost: AttachmentPost): Attachment? {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        var ticket : Ticket?
        try {
            ticket = ticketRepository.findByIdOrNull(ticketId)
        }catch (exception: Exception){
            throw TicketsException(ERROR_GETTING_TICKET, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        try{
            return attachmentRepository.save(attachmentPost.toAttachment(ticketId))
        }catch (exception: Exception){
            throw TicketsException("Error saving attachment", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun createTicket(ticketPost: TicketPost): Ticket? {
        var savedTicked : Ticket
        try{
            savedTicked = ticketRepository.save(ticketPost.toTicket())
        }catch (exception: Exception){
            throw TicketsException("Error saving ticket",HttpStatus.INTERNAL_SERVER_ERROR)
        }

        if(savedTicked.ticketId != null){
            var msgSet = HashSet<Message>()
            msgSet.add(saveMessage(savedTicked, ticketPost.comment))
            savedTicked.messages = msgSet
        }
        return savedTicked
    }

    private fun saveMessage(savedTicked: Ticket, comment: String): Message {
        val msg = Message.fromTicket(savedTicked, comment)
        try{
            return messageRepository.save(msg)
        }catch (exception: Exception){
            throw TicketsException("Error saving message", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    fun createTicketMessage(ticketId: UUID, messagePost: MessagePost): Message? {

        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        var ticket : Ticket?
        try {
            ticket = ticketRepository.findByIdOrNull(ticketId)
        }catch (exception: Exception){
            throw TicketsException(ERROR_GETTING_TICKET, HttpStatus.INTERNAL_SERVER_ERROR)
        }
        if(ticket == null)
            throw TicketsException("Ticket id does not exist", HttpStatus.NOT_FOUND)

        try{
            return messageRepository.save(messagePost.toMessage(ticket.ticketId!!))
        }catch (exception: Exception){
            throw TicketsException("Error saving message", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun deleteAttachmentById(ticketId: UUID, attachmentId: UUID) {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        if(!attachmentRepository.existsById(attachmentId))
            throw TicketsException("Attachment Id does not exist", HttpStatus.NOT_FOUND)

        try {
            attachmentRepository.deleteById(attachmentId)
        }catch (exception: Exception){
            throw TicketsException("Error deleting attachment", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun deleteTicketById(ticketId: UUID) {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        try {
            //TODO Test if it is deleting messages and attachments before implementing todos
            //TODO delete messages associated
            //TODO delete attachments associated
            ticketRepository.deleteById(ticketId)
        }catch (exception: Exception){
            throw TicketsException("Error deleting ticket", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun deleteTicketMessageById(ticketId: UUID, messageId: UUID) {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        if(!messageRepository.existsById(messageId))
            throw TicketsException("Message Id does not exist", HttpStatus.NOT_FOUND)

        try {
            messageRepository.deleteById(messageId)
        }catch (exception: Exception){
            throw TicketsException("Error deleting ticket", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getAttachmentById(ticketId: UUID, attachmentId: UUID): Attachment? {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        if(!attachmentRepository.existsById(attachmentId))
            throw TicketsException("Attachment Id does not exist", HttpStatus.NOT_FOUND)

        try {
            return attachmentRepository.findByIdOrNull(attachmentId)
        }catch (exception: Exception){
            throw TicketsException("Error getting Attachment", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getTicketById(ticketId: UUID): Ticket? {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)
        try {
            return ticketRepository.findByIdOrNull(ticketId)
        }catch (exception: Exception){
            throw TicketsException(ERROR_GETTING_TICKET, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getTicketMessageById(ticketId: UUID, messageId: UUID): Message? {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        if(!messageRepository.existsById(messageId))
            throw TicketsException("Message Id does not exist", HttpStatus.NOT_FOUND)

        try {
            return messageRepository.findByIdOrNull(messageId)
        }catch (exception: Exception){
            throw TicketsException("Error getting Message", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getTicketMessages(ticketId: UUID): List<Message>? {
        if(!ticketRepository.existsById(ticketId))
            throw TicketsException(TICKET_ID_DOES_NOT_EXIST, HttpStatus.NOT_FOUND)

        try {
            val ticket = ticketRepository.findByIdOrNull(ticketId)
                    ?: throw TicketsException(ERROR_GETTING_TICKET, HttpStatus.INTERNAL_SERVER_ERROR)
            val msgs = ticket.messages ?: return emptyList()
            return msgs.toList()

        }catch (exception: NoSuchElementException){
            return emptyList()
        }catch (exception: TicketsException){
            throw exception
        }catch (exception: Exception){
            throw TicketsException("Error getting Attachment", HttpStatus.INTERNAL_SERVER_ERROR)
        }
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