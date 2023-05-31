package pt.isel.leic.ps.qless.webapi.exceptions

import org.springframework.http.HttpStatus

class CategoriesException(message: String?, statusCode: HttpStatus) : QLessException(message, statusCode) {
}