package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import pt.isel.leic.ps.qless.webapi.entities.Attachment
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Size

/**
 * 
 * @param ticketId 
 * @param createDate 
 * @param content 
 * @param name 
 */
data class AttachmentPost(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("createDate", required = true) val createDate: java.time.OffsetDateTime,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("content", required = true) val content: ByteArray,

    @get:Size(max=255)
    @Schema(example = "null", description = "")
    @get:JsonProperty("name") val name: kotlin.String? = null
) {
    fun toAttachment(ticketId: UUID): Attachment {
        return Attachment(null, ticketId, createDate, content, name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AttachmentPost

        if (ticketId != other.ticketId) return false
        if (createDate != other.createDate) return false
        if (!content.contentEquals(other.content)) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ticketId.hashCode()
        result = 31 * result + createDate.hashCode()
        result = 31 * result + content.contentHashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

}

