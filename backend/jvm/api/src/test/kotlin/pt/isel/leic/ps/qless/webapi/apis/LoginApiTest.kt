package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.Credentials
import pt.isel.leic.ps.qless.webapi.models.Token
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class LoginApiTest {

    private val api: LoginApiController = LoginApiController()

    /**
     * To test LoginApiController.loginUser
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun loginUserTest() {
        val credentials: Credentials? = TODO()
        val response: ResponseEntity<Token> = api.loginUser(credentials)

        // TODO: test validations
    }
}
