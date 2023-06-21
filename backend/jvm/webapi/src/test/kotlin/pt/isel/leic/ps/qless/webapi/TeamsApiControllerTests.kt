package pt.isel.leic.ps.qless.webapi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import pt.isel.leic.ps.qless.webapi.apis.TeamsApiController
import pt.isel.leic.ps.qless.webapi.services.TeamsApiService
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import pt.isel.leic.ps.qless.webapi.entities.Team
import java.util.*


@ExtendWith(MockitoExtension::class)

class TeamsApiControllerTests {

    @Mock
    private lateinit var teamsApiService: TeamsApiService

    @InjectMocks
    private lateinit var teamsApiController: TeamsApiController

    @Test
    fun createTeamTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val teamPost = TeamPost("New Team")

        val createdTeam = Team(teamId, teamPost.name)
        val expectedResponse = ResponseEntity.ok(createdTeam)

        `when`(teamsApiService.createTeam(teamPost)).thenReturn(createdTeam)

        // Act
        val response = teamsApiController.createTeam(teamPost)

        // Assert
        assertEquals(expectedResponse, response)
    }

    @Test
    fun deleteTeamByIdTest() {
        // Arrange
        val teamId = UUID.randomUUID()

        // Act
        teamsApiController.deleteTeamById(teamId)

        // Assert
        verify(teamsApiService).deleteTeamById(teamId)
    }

    @Test
    fun getAllTeamsTest() {
        // Arrange
        val team1 = Team(UUID.randomUUID(), "Team 1")
        val team2 = Team(UUID.randomUUID(), "Team 2")
        val team3 = Team(UUID.randomUUID(), "Team 3")
        val teams = listOf(team1, team2, team3)
        val expectedResponse = ResponseEntity.ok(teams)

        `when`(teamsApiService.getAllTeams()).thenReturn(teams)

        // Act
        val response = teamsApiController.getAllTeams()

        // Assert
        assertEquals(expectedResponse, response)
    }
    @Test
    fun getTeamByIdTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val team = Team(teamId, "Team Name")
        val expectedResponse = ResponseEntity.ok(team)

        `when`(teamsApiService.getTeamById(teamId)).thenReturn(team)

        // Act
        val response = teamsApiController.getTeamById(teamId)

        // Assert
        assertEquals(expectedResponse, response)
    }

    @Test
    fun updateTeamByIdTest() {
        // Arrange
        val teamId = UUID.randomUUID()
        val team = Team(teamId, "Updated Team")
        val expectedResponse = ResponseEntity.ok(team)

        `when`(teamsApiService.updateTeamById(teamId, team)).thenReturn(team)

        // Act
        val response = teamsApiController.updateTeamById(teamId, team)

        // Assert
        assertEquals(expectedResponse, response)
    }

}