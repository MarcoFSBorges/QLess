package pt.isel.leic.ps.qless.webapi.exceptions

import org.springframework.http.HttpStatus
open class QLessException(message: String?, statusCode: HttpStatus) : Exception(message) {
}