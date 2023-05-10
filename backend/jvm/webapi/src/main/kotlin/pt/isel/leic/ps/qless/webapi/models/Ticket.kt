package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * 
 * @param id 
 * @param comment 
 * @param status 
 * @param category 
 * @param createDate 
 * @param updateDate 
 * @param solvedDate 
 */
@Entity
data class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(example = "null", readOnly = true, description = "")
    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("comment", required = true) val comment: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("status", required = true) val status: Ticket.Status = Status.cREATED,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("category", required = true) val category: kotlin.String,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("create_date", required = true) val createDate: java.time.OffsetDateTime,

    @Schema(example = "null", description = "")
    @get:JsonProperty("update_date") val updateDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("solved_date") val solvedDate: java.time.OffsetDateTime? = null
) {

    /**
    * 
    * Values: cREATED,oNGOING,sOLVED,cANCELLED,aRCHIVED
    */
    enum class Status(val value: kotlin.String) {

        @JsonProperty("CREATED") cREATED("CREATED"),
        @JsonProperty("ON_GOING") oNGOING("ON_GOING"),
        @JsonProperty("SOLVED") sOLVED("SOLVED"),
        @JsonProperty("CANCELLED") cANCELLED("CANCELLED"),
        @JsonProperty("ARCHIVED") aRCHIVED("ARCHIVED")
    }

}

