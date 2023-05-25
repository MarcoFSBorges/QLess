package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.Session
import pt.isel.leic.ps.qless.webapi.models.User
import pt.isel.leic.ps.qless.webapi.models.UserPost
import pt.isel.leic.ps.qless.webapi.repositories.SessionRepository
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository
import java.util.*

@Service
class SignupApiService(private val userRepository: UserRepository,
                       private val sessionRepository: SessionRepository
        ) {
    fun signUp(userPost: UserPost?): User? {
        if(userPost != null){
            //1 Check username doesn't exist
            //TODO: Create query to find by username
            val users = userRepository.findAll()
            var user = userPost.toUser()
            var userExists = false
            for (u in users) {
                if(u.username.equals(userPost.username)){
                    userExists = true
                }
            }
            //2 save new User
            if(!userExists){
                user = userRepository.save(user)
            }

            //3 Generate Sesison Token
            println(user)
            return user
        }
        return null
    }


}