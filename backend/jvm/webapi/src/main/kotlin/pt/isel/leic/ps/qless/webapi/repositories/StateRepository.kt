package pt.isel.leic.ps.qless.webapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import pt.isel.leic.ps.qless.webapi.entities.Category
import pt.isel.leic.ps.qless.webapi.entities.State
import java.util.*


@Repository
interface StateRepository : JpaRepository<State, UUID> {

    @Query("SELECT s from State s where s.name = ?1")
    fun getStateByName(stateName: String): State
}