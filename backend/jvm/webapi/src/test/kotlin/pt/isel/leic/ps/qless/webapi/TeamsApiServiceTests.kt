package pt.isel.leic.ps.qless.webapi

import org.junit.Assert
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.dao.OptimisticLockingFailureException
import pt.isel.leic.ps.qless.webapi.entities.Team
import pt.isel.leic.ps.qless.webapi.exceptions.TeamsException
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.repositories.TeamRepository
import pt.isel.leic.ps.qless.webapi.services.TeamsApiService
import java.util.*

@ExtendWith(MockitoExtension::class)
class TeamsApiServiceTests {



    @Mock
    private lateinit var  teamRepository: TeamRepository
    @InjectMocks
    private lateinit var teamService : TeamsApiService

    @Test
    fun createTeamSimpleTest() {
        // Arrange
        val teamPost = TeamPost("New Team")

        val createdTeam = Team(UUID.randomUUID(), teamPost.name)

        `when`(teamRepository.save(ArgumentMatchers.any(Team::class.java))).thenReturn(createdTeam)

        // Act
        val response = teamService.createTeam(teamPost)

        // Assert
        assertEquals(createdTeam.teamId, response!!.teamId)
        Assert.assertEquals(teamPost.name, response.name)
    }

    @Test
    fun createTeamIllegalArgumentExceptionTest() {
        // Arrange
        val teamPost = TeamPost("New Team")

        `when`(teamRepository.save(ArgumentMatchers.any(Team::class.java))).thenThrow(IllegalArgumentException::class.java)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.createTeam(teamPost)
        }
    }

    @Test
    fun createTeamOptimisticLockingFailureExceptionTest() {
        // Arrange
        val teamPost = TeamPost("New Team")

        `when`(teamRepository.save(ArgumentMatchers.any(Team::class.java)))
            .thenThrow(OptimisticLockingFailureException::class.java)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.createTeam(teamPost)
        }
    }
    @Test
    fun deleteTeamByIdSimpleTest() {
        // Arrange
        val teamId = UUID.randomUUID()

        // Act
        teamService.deleteTeamById(teamId)

        // Assert
        Mockito.verify(teamRepository).deleteById(teamId)
    }

    @Test
    fun deleteTeamByIdExceptionTest() {
        // Arrange
        val teamId = UUID.randomUUID()

        doThrow(RuntimeException::class.java)
            .`when`(teamRepository).deleteById(ArgumentMatchers.any())

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.deleteTeamById(teamId)
        }
    }
    @Test
    fun getAllTeamsSimpleTest() {
        // Arrange
        val team1 = Team(UUID.randomUUID(), "Team 1")
        val team2 = Team(UUID.randomUUID(), "Team 2")
        val teams = listOf(team1, team2)

        `when`(teamRepository.findAll()).thenReturn(teams)

        // Act
        val response = teamService.getAllTeams()

        // Assert
        asserTeamsEquals(teams,response)

    }



    @Test
    fun getAllTeamsExceptionTest() {
        // Arrange
        `when`(teamRepository.findAll()).thenThrow(RuntimeException::class.java)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.getAllTeams()
        }
    }

    @Test
    fun getTeamByIdExistingTeamTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val existingTeam = Team(teamId, "Existing Team")

        `when`(teamRepository.findById(teamId)).thenReturn(Optional.of(existingTeam))

        // Act
        val response = teamService.getTeamById(teamId)

        // Assert
        assertEquals(existingTeam.teamId, response?.teamId)
        assertEquals(existingTeam.name, response?.name)
    }

    @Test
    fun getTeamByIdNonExistingTeamTest() {
        // Arrange
        val teamId = UUID.randomUUID()

        `when`(teamRepository.findById(teamId)).thenReturn(null)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.getTeamById(teamId)
        }
    }

    @Test
    fun getTeamByIdExceptionTest() {
        // Arrange
        val teamId = UUID.randomUUID()

        `when`(teamRepository.findById(teamId)).thenThrow(RuntimeException::class.java)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.getTeamById(teamId)
        }
    }

    @Test
    fun updateTeamByIdExistingTeamTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val existingTeam = Team(teamId, "Existing Team")
        val updatedTeam = Team(teamId, "Updated Team")

        `when`(teamRepository.findById(teamId)).thenReturn(Optional.of(existingTeam))
        `when`(teamRepository.save(updatedTeam)).thenReturn(updatedTeam)

        // Act
        val response = teamService.updateTeamById(teamId, updatedTeam)

        // Assert
        assertEquals(updatedTeam.teamId, response?.teamId)
        assertEquals(updatedTeam.name, response?.name)
    }

    @Test
    fun updateTeamByIdNonExistingTeamTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val updatedTeam = Team(teamId, "Updated Team")

        `when`(teamRepository.findById(teamId)).thenReturn(null)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.updateTeamById(teamId, updatedTeam)
        }
    }

    @Test
    fun updateTeamByIdExceptionTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val updatedTeam = Team(teamId, "Updated Team")

        `when`(teamRepository.findById(teamId)).thenThrow(RuntimeException::class.java)

        // Assert
        assertThrows<TeamsException> {
            // Act
            teamService.updateTeamById(teamId, updatedTeam)
        }
    }


    private fun asserTeamsEquals(teams: List<Team>, response: List<Team>?) {
        assertEquals(teams.size, response?.size)
        asserTeamEquals(teams[0], response?.get(0)!!)
        asserTeamEquals(teams[1], response?.get(1)!!)
    }
    private fun asserTeamEquals(teams: Team, response: Team) {
        assertEquals(teams.teamId, response.teamId)
        assertEquals(teams.name, response.name)
    }


}