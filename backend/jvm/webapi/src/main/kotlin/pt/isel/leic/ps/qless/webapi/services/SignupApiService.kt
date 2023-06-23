package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.Session
import pt.isel.leic.ps.qless.webapi.entities.User
import pt.isel.leic.ps.qless.webapi.exceptions.QLessException
import pt.isel.leic.ps.qless.webapi.exceptions.SignUpException
import pt.isel.leic.ps.qless.webapi.models.UserPost
import pt.isel.leic.ps.qless.webapi.repositories.SessionRepository
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class SignupApiService(
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository
    ) {

    val passwordEncoder = BCryptPasswordEncoder()
    fun signUp(userPost: UserPost?): User? {
        if(userPost != null){
            var user = userPost.toUser()
            try {
                //1 Check user doesn't exist
                val userFound = userRepository.findByEmail(user.email)
                if(userFound == null) {
                    user.password = passwordEncoder.encode(userPost.password)
                    user = userRepository.save(user)
                }
                else
                    throw SignUpException("User already registered with that email!", HttpStatus.CONFLICT)
                //3 Generate Session Token
                sessionRepository.save(Session(null, user.userId))
            }catch (e: Exception){
                throw(e)
            }
            println(user)
            return user
        }
        return null
    }


}