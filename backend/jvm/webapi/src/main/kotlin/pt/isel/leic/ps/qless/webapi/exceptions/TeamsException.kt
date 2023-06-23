package pt.isel.leic.ps.qless.webapi.exceptions

import org.springframework.http.HttpStatus

class TeamsException(message: String?,var statusCode: HttpStatus) : QLessException(message, statusCode) {
}