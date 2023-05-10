package pt.isel.leic.ps.qless.webapi.controllers

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pt.isel.leic.ps.qless.webapi.models.Ticket
import pt.isel.leic.ps.qless.webapi.models.TicketPost
import pt.isel.leic.ps.qless.webapi.repositories.TicketRepository
import java.util.*
import javax.validation.Valid

@RestController
@Validated
class TicketsApiController(private val ticketRepository: TicketRepository) {

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
    fun createTicket(@Parameter(description = "Ticket object to be created") @Valid @RequestBody(required = false) ticketPost: TicketPost?): ResponseEntity<Ticket> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
        value = ["/tickets/{id}"]
    )
    fun deleteTicketById(@Parameter(description = "ID of ticket to retrieve", required = true) @PathVariable("id") id: java.util.UUID): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Retrieve all tickets",
        operationId = "getAllTickets",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Ticket::class))]) ],
        security = [ SecurityRequirement(name = "basicAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/tickets"],
        produces = ["application/json"]
    )
    fun getAllTickets(): ResponseEntity<List<Ticket>> {
        val tickets = ticketRepository.findAll().toList();
        return ResponseEntity.ok(tickets)
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
        value = ["/tickets/{id}"],
        produces = ["application/json"]
    )
    fun getTicketById(@Parameter(description = "ID of ticket to retrieve", required = true) @PathVariable("id") id: java.util.UUID): ResponseEntity<Ticket> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
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
        value = ["/tickets/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTicketById(@Parameter(description = "ID of ticket to retrieve", required = true) @PathVariable("id") id: java.util.UUID,@Parameter(description = "Ticket object to be updated") @Valid @RequestBody(required = false) ticket: Ticket?): ResponseEntity<Ticket> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
