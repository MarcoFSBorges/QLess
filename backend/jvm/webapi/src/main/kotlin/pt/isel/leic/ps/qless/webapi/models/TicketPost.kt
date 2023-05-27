package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.Message
import pt.isel.leic.ps.qless.webapi.entities.Ticket
import java.util.UUID

/**
 * 
 * @param category 
 * @param comment 
 * @param createDate 
 */
data class TicketPost(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("categoryId", required = true) val categoryId: UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("openedBy", required = true) val openedBy: UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("comment", required = true) val comment: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("create_date", required = true) val createDate: java.time.OffsetDateTime
) {
    fun toTicket(): Ticket {
        return Ticket(categoryId = categoryId,  openedBy = openedBy, createDate = createDate )
    }

}

