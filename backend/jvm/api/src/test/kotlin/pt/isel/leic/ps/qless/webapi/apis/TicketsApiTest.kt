package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Attachment
import pt.isel.leic.ps.qless.webapi.models.AttachmentPost
import pt.isel.leic.ps.qless.webapi.models.Message
import pt.isel.leic.ps.qless.webapi.models.MessagePost
import pt.isel.leic.ps.qless.webapi.models.Ticket
import pt.isel.leic.ps.qless.webapi.models.TicketPost
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class TicketsApiTest {

    private val api: TicketsApiController = TicketsApiController()

    /**
     * To test TicketsApiController.createAttachment
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createAttachmentTest() {
        val ticketId: java.util.UUID = TODO()
        val attachmentPost: AttachmentPost? = TODO()
        val response: ResponseEntity<Attachment> = api.createAttachment(ticketId, attachmentPost)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.createTicket
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createTicketTest() {
        val ticketPost: TicketPost? = TODO()
        val response: ResponseEntity<Ticket> = api.createTicket(ticketPost)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.createTicketMessage
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createTicketMessageTest() {
        val ticketId: java.util.UUID = TODO()
        val messagePost: MessagePost? = TODO()
        val response: ResponseEntity<Message> = api.createTicketMessage(ticketId, messagePost)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.deleteAttachmentById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteAttachmentByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val attachmentId: java.util.UUID = TODO()
        val response: ResponseEntity<Unit> = api.deleteAttachmentById(ticketId, attachmentId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.deleteTicketById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteTicketByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val response: ResponseEntity<Unit> = api.deleteTicketById(ticketId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.deleteTicketMessageById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteTicketMessageByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val messageId: java.util.UUID = TODO()
        val response: ResponseEntity<Unit> = api.deleteTicketMessageById(ticketId, messageId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getAllTickets
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getAllTicketsTest() {
        val response: ResponseEntity<List<Ticket>> = api.getAllTickets()

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getAttachmentById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getAttachmentByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val attachmentId: java.util.UUID = TODO()
        val response: ResponseEntity<Attachment> = api.getAttachmentById(ticketId, attachmentId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getAttachmentsByTicketId
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getAttachmentsByTicketIdTest() {
        val ticketId: java.util.UUID = TODO()
        val response: ResponseEntity<List<Attachment>> = api.getAttachmentsByTicketId(ticketId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getTicketById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getTicketByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val response: ResponseEntity<Ticket> = api.getTicketById(ticketId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getTicketMessageById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getTicketMessageByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val messageId: java.util.UUID = TODO()
        val response: ResponseEntity<Message> = api.getTicketMessageById(ticketId, messageId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.getTicketMessages
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getTicketMessagesTest() {
        val ticketId: java.util.UUID = TODO()
        val response: ResponseEntity<List<Message>> = api.getTicketMessages(ticketId)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.updateAttachmentById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun updateAttachmentByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val attachmentId: java.util.UUID = TODO()
        val attachment: Attachment? = TODO()
        val response: ResponseEntity<Attachment> = api.updateAttachmentById(ticketId, attachmentId, attachment)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.updateTicketById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun updateTicketByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val ticket: Ticket? = TODO()
        val response: ResponseEntity<Ticket> = api.updateTicketById(ticketId, ticket)

        // TODO: test validations
    }

    /**
     * To test TicketsApiController.updateTicketMessageById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun updateTicketMessageByIdTest() {
        val ticketId: java.util.UUID = TODO()
        val messageId: java.util.UUID = TODO()
        val message: Message? = TODO()
        val response: ResponseEntity<Message> = api.updateTicketMessageById(ticketId, messageId, message)

        // TODO: test validations
    }
}
