package pt.isel.leic.ps.qless.webapi.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

/**
 * 
 * @param ticketId 
 * @param openedBy 
 * @param categoryId 
 * @param stateId 
 * @param createDate 
 * @param treatedBy 
 * @param updateDate 
 * @param solvedDate 
 */
@Entity
data class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("ticketId", required = true) val ticketId: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("openedBy", required = true) val openedBy: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("categoryId", required = true) val categoryId: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("stateId", required = true) val stateId: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("create_date", required = true) val createDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("treatedBy") val treatedBy: java.util.UUID? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("update_date") val updateDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("solved_date") val solvedDate: java.time.OffsetDateTime? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "tickedId", referencedColumnName = "ticketId")
    @get:JsonProperty("messages")var messages: Set<Message>? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "tickedId", referencedColumnName = "ticketId")
    @get:JsonProperty("attachments")var attachments: Set<Attachment>? = null


) {

}

