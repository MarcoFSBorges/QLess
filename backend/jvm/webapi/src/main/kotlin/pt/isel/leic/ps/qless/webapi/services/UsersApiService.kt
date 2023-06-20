package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.User
import pt.isel.leic.ps.qless.webapi.exceptions.TeamsException
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository
import java.util.*

@Service
class UsersApiService(
        private val userRepository: UserRepository,
) {

    fun getUserByEmail(email: String): User? {
        try {
            val user = userRepository.findByEmail(email)
            if(user != null)
                return user
            else
                throw TeamsException("User with specified email does not exist", HttpStatus.NOT_FOUND)
        } catch (exception: Exception) {
            throw TeamsException("Error getting user", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }




}