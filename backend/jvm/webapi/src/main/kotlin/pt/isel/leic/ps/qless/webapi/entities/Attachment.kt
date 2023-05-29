package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.Size

/**
 * 
 * @param attachmentId 
 * @param ticketId 
 * @param createDate 
 * @param content 
 * @param name 
 */
@Entity
data class Attachment(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("attachmentId", required = true) val attachmentId: java.util.UUID,

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
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Attachment

        if (attachmentId != other.attachmentId) return false

        return true
    }

    override fun hashCode(): Int {
        return attachmentId.hashCode()
    }

}

