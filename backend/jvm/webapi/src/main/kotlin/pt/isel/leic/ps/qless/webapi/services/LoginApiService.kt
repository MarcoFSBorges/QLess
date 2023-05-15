package pt.isel.leic.ps.qless.webapi.services

import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.repositories.UserRepository

@Service
class LoginApiService(private val userRepository: UserRepository
        ) {


}