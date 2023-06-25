package pt.isel.leic.ps.qless.webapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

data class TicketPostInfo(
        @Schema(example = "null", required = true, description = "")
        @get:JsonProperty("categoryId", required = true) val categoryId: java.util.UUID,

        @Schema(example = "null", required = true, description = "")
        @get:JsonProperty("comment", required = true) val comment: kotlin.String
)