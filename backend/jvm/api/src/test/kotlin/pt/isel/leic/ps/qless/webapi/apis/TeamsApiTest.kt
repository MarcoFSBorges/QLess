package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Team
import pt.isel.leic.ps.qless.webapi.models.TeamPost
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class TeamsApiTest {

    private val api: TeamsApiController = TeamsApiController()

    /**
     * To test TeamsApiController.createTeam
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createTeamTest() {
        val teamPost: TeamPost? = TODO()
        val response: ResponseEntity<Team> = api.createTeam(teamPost)

        // TODO: test validations
    }

    /**
     * To test TeamsApiController.deleteTeamById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteTeamByIdTest() {
        val teamId: java.util.UUID = TODO()
        val response: ResponseEntity<Unit> = api.deleteTeamById(teamId)

        // TODO: test validations
    }

    /**
     * To test TeamsApiController.getAllTeams
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getAllTeamsTest() {
        val response: ResponseEntity<List<Team>> = api.getAllTeams()

        // TODO: test validations
    }

    /**
     * To test TeamsApiController.getTeamById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getTeamByIdTest() {
        val teamId: java.util.UUID = TODO()
        val response: ResponseEntity<Team> = api.getTeamById(teamId)

        // TODO: test validations
    }

    /**
     * To test TeamsApiController.updateTeamById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun updateTeamByIdTest() {
        val teamId: java.util.UUID = TODO()
        val team: Team? = TODO()
        val response: ResponseEntity<Team> = api.updateTeamById(teamId, team)

        // TODO: test validations
    }
}
