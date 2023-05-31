package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.User
import pt.isel.leic.ps.qless.webapi.exceptions.QLessException
import pt.isel.leic.ps.qless.webapi.exceptions.SignUpException
import pt.isel.leic.ps.qless.webapi.models.UserPost
import pt.isel.leic.ps.qless.webapi.repositories.SessionRepository
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class SignupApiService(private val userRepository: UserRepository,
                       private val sessionRepository: SessionRepository
        ) {
    fun signUp(userPost: UserPost?): User? {
        if(userPost != null){
            var user = userPost.toUser()
            try {
                //1 Check username doesn't exist
                val userFound = userRepository.findByEmail(userPost.email)
                if(userFound != null)
                    user = userFound
                else
                    throw SignUpException("Internal error getting user", HttpStatus.INTERNAL_SERVER_ERROR)
                //3 Generate Session Token
            }catch (exception: Exception){
                user = userRepository.save(user)
            }
            println(user)
            return user
        }
        return null
    }


}