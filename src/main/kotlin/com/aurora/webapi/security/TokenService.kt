package com.aurora.webapi.security

import com.aurora.webapi.modules.usuarios.infra.entity.User
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class TokenService(
    @Value("\${api.security.token.secret}")
    private val secret: String
) {


    fun generateWebToken(user: User): String {
        return try {

            val roleNames = user.roles?.map { it.name }
            val algorithm = Algorithm.HMAC256(secret)
            JWT.create()
                .withIssuer("Api storeFood")
                .withSubject(user.login)
                .withJWTId(user.id.toString())
                .withClaim("roles", roleNames)
                .withClaim("name", user.name)
                .withExpiresAt(Date.from(expirationDate()))
                .sign(algorithm)
        } catch (ex: JWTCreationException) {
            throw RuntimeException("Erro ao gerar o token JWT", ex)
        }
    }

    fun getSubject(token: String): String {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("Api storeFood")
                .build()
                .verify(token)
                .subject
        } catch (ex: JWTVerificationException) {
            throw RuntimeException("Token inválido ou expirado!", ex)
        }
    }

    private fun expirationDate(): Instant {
        return LocalDateTime.now().plusSeconds(3600)
            .toInstant(ZoneOffset.of("-03:00"))
    }
}