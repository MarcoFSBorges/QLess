package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.Message
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import java.time.OffsetDateTime
import java.util.*

/**
 * 
 * @param sender 
 * @param content 
 */
data class MessagePost(

    @Schema(example = "null", description = "")
    @get:JsonProperty("isEmployee") val isEmployee: Boolean ,

    @Schema(example = "null", description = "")
    @get:JsonProperty("content") val content: kotlin.String
) {
    fun toMessage(ticketId: UUID): Message {
        return Message(null, ticketId, isEmployee, content, OffsetDateTime.now())
    }

}

