package com.aurora.webapi.security

import com.aurora.webapi.modules.auth.repository.UserRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
class SecurityFilter(
    val tokenService: TokenService,
    val userRepository: UserRepository
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenJWT = getToken(request)

        if (tokenJWT != null) {
            val subject = tokenService.getSubject(tokenJWT)
            val usuario = userRepository.findByLogin(subject)

            val authentication = UsernamePasswordAuthenticationToken(
                usuario, null, usuario.authorities
            )
            SecurityContextHolder.getContext().authentication = authentication

            println("Logado")
        }

        filterChain.doFilter(request, response)
    }

    private fun getToken(request: HttpServletRequest): String? {
        val authorization = request.getHeader("Authorization")
        return if (!authorization.isNullOrBlank() && authorization.startsWith("Bearer ")) {
            authorization.removePrefix("Bearer ").trim()
        } else {
            null
        }
    }
}