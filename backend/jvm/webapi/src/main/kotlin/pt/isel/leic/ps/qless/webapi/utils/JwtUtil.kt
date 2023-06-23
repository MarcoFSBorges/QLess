package pt.isel.leic.ps.qless.webapi.utils

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import pt.isel.leic.ps.qless.webapi.entities.User
import java.util.*

object JwtUtil {

    @Value("\${jwt.secret}")
    private lateinit var SECRET_KEY: String

    private val signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)

    fun validateToken(cookie: String): User {
        val validate =  Jwts.parserBuilder().setSigningKey(signingKey).build().parse(cookie)
        return User.fromToken(validate.header)
    }

    fun generateToken(user: User): String {
        val now = Date()
        val expiryDate = Date(now.time + 86400000) // Set token expiration to 24 hours



        val headers : MutableMap<String, Any> = mutableMapOf()

        headers["userId"] = user.userId.toString()
        headers["email"] = user.email
        headers["fname"] = user.fname.toString()
        headers["lname"] = user.lname.toString()



        return Jwts.builder()
                .setHeader(headers)
                .setSubject(user.userId.toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact()
    }
}