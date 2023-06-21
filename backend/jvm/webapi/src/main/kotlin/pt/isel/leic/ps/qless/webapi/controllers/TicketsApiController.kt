package pt.isel.leic.ps.qless.webapi.apis

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.entities.Attachment
import pt.isel.leic.ps.qless.webapi.entities.Message
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import pt.isel.leic.ps.qless.webapi.models.*
import pt.isel.leic.ps.qless.webapi.services.TicketsApiService
import java.util.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class TicketsApiController(private val ticketsApiService: TicketsApiService) {

    @Operation(
        summary = "Create a new attachment for a ticket",
        operationId = "createAttachment",
        description = """""",
        responses = [
            ApiResponse(responseCode = "201", description = "Created", content = [Content(schema = Schema(implementation = Attachment::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/tickets/{ticketId}/attachments"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createAttachment(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "Attachment object to be created")
            @Valid @RequestBody(required = false)
            attachmentPost: AttachmentPost?): ResponseEntity<Attachment> {
        return ResponseEntity.ok(attachmentPost?.let { ticketsApiService.createAttachment(ticketId, it) })
    }

    @Operation(
        summary = "Create a new ticket",
        operationId = "createTicket",
        description = """""",
        responses = [
            ApiResponse(responseCode = "201", description = "Created", content = [Content(schema = Schema(implementation = Ticket::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/tickets"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTicket(
            @Parameter(description = "Ticket object to be created")
            @Valid
            @RequestBody(required = false)
            ticketPost: TicketPost?): ResponseEntity<Ticket> {
        return ResponseEntity.ok(ticketsApiService.createTicket(ticketPost!!))
    }

    @Operation(
        summary = "Create a new message for a specific ticket",
        operationId = "createTicketMessage",
        description = """""",
        responses = [
            ApiResponse(responseCode = "201", description = "Created", content = [Content(schema = Schema(implementation = Message::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/tickets/{ticketId}/messages"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTicketMessage(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "Message object to be created")
            @Valid
            @RequestBody(required = false)
            messagePost: MessagePost?): ResponseEntity<Message> {
        return ResponseEntity.ok(ticketsApiService.createTicketMessage(ticketId, messagePost!!))
    }

    @Operation(
        summary = "Delete a specific attachment of a ticket",
        operationId = "deleteAttachmentById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "204", description = "No content") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/tickets/{ticketId}/attachments/{attachmentId}"]
    )
    fun deleteAttachmentById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "ID of Message to retrieve", required = true)
            @PathVariable("attachmentId")
            attachmentId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity.ok(ticketsApiService.deleteAttachmentById(ticketId,attachmentId))
    }

    @Operation(
        summary = "Delete a specific ticket",
        operationId = "deleteTicketById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "204", description = "No content") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/tickets/{ticketId}"]
    )
    fun deleteTicketById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity.ok(ticketsApiService.deleteTicketById(ticketId))
    }

    @Operation(
        summary = "Delete a specific message for a ticket",
        operationId = "deleteTicketMessageById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "204", description = "No content") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.DELETE],
        value = ["/tickets/{ticketId}/messages/{messageId}"]
    )
    fun deleteTicketMessageById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "ID of Message to retrieve", required = true)
            @PathVariable("messageId")
            messageId: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity.ok(ticketsApiService.deleteTicketMessageById(ticketId,messageId))
    }


    @Operation(
        summary = "Retrieve all tickets by user",
        operationId = "getAllTicketsByUser",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Ticket::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )

    @CrossOrigin(origins = ["http://localhost:5173"], methods = [RequestMethod.GET], allowCredentials = "true")
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{userId}"],
        produces = ["application/json"]
    )
    fun getAllTicketsByUser(
            @Parameter(description = "Id of user to retrieve his tickets", required = true)
            @PathVariable("userId")
            userId: UUID): ResponseEntity<List<Any?>> {
        return ResponseEntity.ok(ticketsApiService.getAllTicketsByUser(userId))
    }

    @Operation(
        summary = "Retrieve a specific attachment of a ticket",
        operationId = "getAttachmentById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Attachment::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{ticketId}/attachments/{attachmentId}"],
        produces = ["application/json"]
    )
    fun getAttachmentById(@Parameter(description = "ID of ticket to retrieve", required = true) @PathVariable("ticketId") ticketId: java.util.UUID,@Parameter(description = "ID of Message to retrieve", required = true) @PathVariable("attachmentId") attachmentId: java.util.UUID): ResponseEntity<Attachment> {
        return ResponseEntity.ok(ticketsApiService.getAttachmentById(ticketId,attachmentId))
    }

    @Operation(
        summary = "Retrieve attachments of a ticket",
        operationId = "getAttachmentsByTicketId",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Attachment::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{ticketId}/attachments"],
        produces = ["application/json"]
    )
    fun getAttachmentsByTicketId(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID): ResponseEntity<List<Attachment>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Retrieve a specific ticket",
        operationId = "getTicketById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Ticket::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{userId}/{ticketId}"],
        produces = ["application/json"]
    )
    fun getTicketById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID): ResponseEntity<Ticket> {
        return ResponseEntity.ok(ticketsApiService.getTicketById(ticketId))
    }

    @Operation(
        summary = "Retrieve a specific message for a ticket",
        operationId = "getTicketMessageById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Message::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{ticketId}/messages/{messageId}"],
        produces = ["application/json"]
    )
    fun getTicketMessageById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "ID of Message to retrieve", required = true)
            @PathVariable("messageId")
            messageId: java.util.UUID): ResponseEntity<Message> {
        return ResponseEntity.ok(ticketsApiService.getTicketMessageById(ticketId,messageId))
    }

    @Operation(
        summary = "Retrieve messages for a specific ticket",
        operationId = "getTicketMessages",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Message::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets/{ticketId}/messages"],
        produces = ["application/json"]
    )
    fun getTicketMessages(@Parameter(description = "ID of ticket to retrieve", required = true) @PathVariable("ticketId") ticketId: java.util.UUID): ResponseEntity<List<Message>> {
        return ResponseEntity.ok(ticketsApiService.getTicketMessages(ticketId))
    }

    @Operation(
        summary = "Update a specific attachment of a ticket",
        operationId = "updateAttachmentById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Attachment::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/tickets/{ticketId}/attachments/{attachmentId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateAttachmentById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "ID of Message to retrieve", required = true)
            @PathVariable("attachmentId")
            attachmentId: java.util.UUID,
            @Parameter(description = "Attachment object to be updated")
            @Valid
            @RequestBody(required = false)
            attachment: Attachment?): ResponseEntity<Attachment> {
        return ResponseEntity.ok(ticketsApiService.updateAttachmentById(ticketId, attachmentId, attachment!!))
    }

    @Operation(
        summary = "Update a specific ticket",
        operationId = "updateTicketById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Ticket::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/tickets/{ticketId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTicketById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "Ticket object to be updated")
            @Valid
            @RequestBody(required = false)
            ticket: Ticket?): ResponseEntity<Ticket> {
        return ResponseEntity.ok(ticketsApiService.updateTicketById(ticketId, ticket!!))
    }

    @Operation(
        summary = "Update a specific message for a ticket",
        operationId = "updateTicketMessageById",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Message::class))]),
            ApiResponse(responseCode = "404", description = "Not found") ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/tickets/{ticketId}/messages/{messageId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTicketMessageById(
            @Parameter(description = "ID of ticket to retrieve", required = true)
            @PathVariable("ticketId")
            ticketId: java.util.UUID,
            @Parameter(description = "ID of Message to retrieve", required = true)
            @PathVariable("messageId")
            messageId: java.util.UUID,
            @Parameter(description = "Message object to be updated")
            @Valid
            @RequestBody(required = false)
            message: Message?): ResponseEntity<Message> {
        return ResponseEntity.ok(ticketsApiService.updateTicketMessageById(ticketId, messageId, message!!))
    }
}
