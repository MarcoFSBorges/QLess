package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param messageId 
 * @param ticketId 
 * @param sender 
 * @param content 
 * @param timestamp 
 */
@Entity
data class Message(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("messageId", required = true) val messageId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("sender", required = true) val sender: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("content", required = true) val content: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime
) {

}

