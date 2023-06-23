package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Credentials
import pt.isel.leic.ps.qless.webapi.models.Token
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class LogoutApiTest {

    private val api: LogoutApiController = LogoutApiController()

    /**
     * To test LogoutApiController.logoutUser
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun logoutUserTest() {
        val credentials: Credentials? = TODO()
        val response: ResponseEntity<Token> = api.logoutUser(credentials)

        // TODO: test validations
    }
}
