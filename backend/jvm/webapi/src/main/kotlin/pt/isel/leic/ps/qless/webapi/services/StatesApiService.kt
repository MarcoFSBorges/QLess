package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.entities.State
import pt.isel.leic.ps.qless.webapi.exceptions.StatesException
import pt.isel.leic.ps.qless.webapi.repositories.StateRepository

@Service
class StatesApiService(
        private val stateRepository: StateRepository
) {
    fun getState(stateName: String): State? {
        try {
            return stateRepository.getStateByName(stateName)
        } catch (exception: Exception) {
            throw StatesException("Error getting state", HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }
}