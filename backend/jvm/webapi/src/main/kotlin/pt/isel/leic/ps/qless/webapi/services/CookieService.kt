package pt.isel.leic.ps.qless.webapi.services

import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import pt.isel.leic.ps.qless.webapi.models.Credentials
import java.util.*

@Service
class CookieService(private val loginService: LoginApiService) {

    fun encode64(name:String, password: String): String{
        val encoder: Base64.Encoder = Base64.getEncoder()
        return encoder.encodeToString("${name}:${password}".encodeToByteArray())
    }

    /*fun setCookie(credentials: Credentials?): ResponseCookie {
            val token = JwtUtilService.generateToken(loginService.login(credentials))
            return  ResponseCookie.from("user-qless", token)
                .httpOnly(true)
                .maxAge(24 * 60 * 60)
                .path("/") // Set the cookie path to be valid for the entire application
                .build()
    }*/

    fun deleteCookie(): ResponseCookie {
        return ResponseCookie.from("user-qless","")
            .maxAge(0)
            .build()
    }


}