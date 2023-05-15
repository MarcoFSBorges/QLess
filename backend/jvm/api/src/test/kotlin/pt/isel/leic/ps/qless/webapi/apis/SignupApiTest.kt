package pt.isel.leic.ps.qless.webapi.apis

import pt.isel.leic.ps.qless.webapi.models.User
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class SignupApiTest {

    private val api: SignupApiController = SignupApiController()

    /**
     * To test SignupApiController.createUser
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun createUserTest() {
        val user: User? = TODO()
        val response: ResponseEntity<User> = api.createUser(user)

        // TODO: test validations
    }
}
