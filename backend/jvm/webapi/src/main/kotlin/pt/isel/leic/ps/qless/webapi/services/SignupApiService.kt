package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.User
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class SignupApiService(private val userRepository: UserRepository
        ) {
    fun signUp(user: User?): User? {
        TODO("Not yet implemented")
    }


}