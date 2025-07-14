package com.aurora.webapi.modules.auth.controller

import com.aurora.webapi.modules.auth.dto.LoginDTO
import com.aurora.webapi.modules.usuarios.infra.entity.User
import com.aurora.webapi.security.TokenJwt
import com.aurora.webapi.security.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/login"])
class AuthController(
    private val manager: AuthenticationManager,
    private val tokenService: TokenService
) {
    @PostMapping
    fun login(@RequestBody loginDTO: LoginDTO): ResponseEntity<TokenJwt> {
        val authToken = UsernamePasswordAuthenticationToken(loginDTO.login, loginDTO.password)
        val authentication = manager.authenticate(authToken)
        val user = authentication.principal as User
        println("Usuário autenticado: ${user.username}")
        val tokenJwt = tokenService.generateWebToken(user)

        return ResponseEntity.ok(TokenJwt(tokenJwt))
    }
}