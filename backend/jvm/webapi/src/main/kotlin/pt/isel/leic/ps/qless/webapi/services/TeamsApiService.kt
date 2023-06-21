package pt.isel.leic.ps.qless.webapi.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Team
import pt.isel.leic.ps.qless.webapi.exceptions.TeamsException
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.repositories.TeamRepository
import java.util.*

@Service
class TeamsApiService(
        private val teamRepository: TeamRepository,
        ) {
    fun createTeam(teamPost: TeamPost): Team? {
        var team = teamPost.toTeam()
        try {
            team = teamRepository.save(team)
        }catch (exception: Exception){
            throw TeamsException("Error saving team", HttpStatus.INTERNAL_SERVER_ERROR)
        }
        return team
    }

    fun deleteTeamById(teamId: UUID) {
        try {
            teamRepository.deleteById(teamId)
        }catch (exception: Exception){
            throw TeamsException("Error deleting team", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getAllTeams(): List<Team>? {
        try {
            return teamRepository.findAll()
        } catch (exception: Exception) {
            throw TeamsException("Error getting teams", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun getTeamById(teamId: UUID): Team? {
        try {
            val team = teamRepository.findByIdOrNull(teamId)
            if(team != null)
                return team
            else
                throw TeamsException("Team Id does not exist", HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            throw TeamsException("Error getting teams", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    fun updateTeamById(teamId: UUID, team: Team): Team? {
        try {
            val savedTeam = teamRepository.findByIdOrNull(teamId)
            if(savedTeam != null)
                return teamRepository.save(team)
            else
                throw TeamsException("Team Id does not exist", HttpStatus.NOT_FOUND)
        }catch (exception: Exception){
            throw TeamsException("Error saving team", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }






}