package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Session
import pt.isel.leic.ps.qless.webapi.entities.User
import pt.isel.leic.ps.qless.webapi.exceptions.LoginException
import pt.isel.leic.ps.qless.webapi.exceptions.SignUpException
import pt.isel.leic.ps.qless.webapi.models.Credentials
import pt.isel.leic.ps.qless.webapi.models.Token
import pt.isel.leic.ps.qless.webapi.repositories.SessionRepository
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class LoginApiService(
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository
) {

    val passwordEncoder = BCryptPasswordEncoder()

    fun login(credentials: Credentials?): User? /*Token?*/ {
        if (credentials != null) {
            try {
                // Check user exists in db
                val registeredUser = userRepository.findByEmail(credentials.email)
                if (registeredUser != null) {
                    if (passwordEncoder.matches(credentials.password, registeredUser.password)) {
                        //Create session token for user
                        sessionRepository.save(Session(null, registeredUser.userId))
                        return registeredUser
                    }
                    else throw LoginException("Wrong password.", HttpStatus.FORBIDDEN)
                } else throw LoginException("User with that email doesn't exist.", HttpStatus.BAD_REQUEST)

            } catch (e: SignUpException) {
                throw (e)
            }
        }
        return null
    }


}