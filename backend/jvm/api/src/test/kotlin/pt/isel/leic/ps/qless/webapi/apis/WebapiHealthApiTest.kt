package pt.isel.leic.ps.qless.webapi.apis

import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class WebapiHealthApiTest {

    private val api: WebapiHealthApiController = WebapiHealthApiController()

    /**
     * To test WebapiHealthApiController.webApiHealth
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun webApiHealthTest() {
        val response: ResponseEntity<kotlin.String> = api.webApiHealth()

        // TODO: test validations
    }
}
