package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.Credentials
import pt.isel.leic.ps.qless.webapi.models.Token
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class LoginApiService(private val userRepository: UserRepository
        ) {
    fun login(credentials: Credentials?): Token? {
        //Check user exists
        //Create session token for user
        TODO("Not yet implemented")
    }


}