package pt.isel.leic.ps.qless.webapi.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

object JwtUtilService {
    private const val SECRET_KEY = "QLessSecretKey" // env variables

    fun generateToken(userEmail: String?): String {
        val now = Date()
        val expiryDate = Date(now.time + 86400000) // Set token expiration to 24 hours

        val signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)

        return Jwts.builder()
            .setSubject(userEmail)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(signingKey, SignatureAlgorithm.HS512)
            .compact()
    }
}