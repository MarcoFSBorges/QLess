package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.Ticket
import pt.isel.leic.ps.qless.webapi.repositories.AttachmentRepository
import pt.isel.leic.ps.qless.webapi.repositories.CategoryRepository
import pt.isel.leic.ps.qless.webapi.repositories.MessageRepository
import pt.isel.leic.ps.qless.webapi.repositories.TicketRepository

@Service
class TeamsApiService(
        private val categoryRepository: CategoryRepository,
        ) {



}