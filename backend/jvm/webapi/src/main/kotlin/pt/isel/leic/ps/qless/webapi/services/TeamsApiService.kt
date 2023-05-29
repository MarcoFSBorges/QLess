package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Team
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.repositories.TeamRepository
import java.util.*

@Service
class TeamsApiService(
        private val teamRepository: TeamRepository,
        ) {
    fun createTeam(teamPost: TeamPost): Team? {
        TODO("Not yet implemented")
    }

    fun deleteTeamById(teamId: UUID): Unit? {
        TODO("Not yet implemented")
    }

    fun getAllTeams(): List<Team>? {
        return teamRepository.findAll()
    }

    fun getTeamById(teamId: UUID): Team? {
        TODO("Not yet implemented")
    }

    fun updateTeamById(teamId: UUID, team: Team): Team? {
        TODO("Not yet implemented")
    }


}