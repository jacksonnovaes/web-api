package com.aurora.webapi.modules.auth.service

import com.aurora.webapi.modules.auth.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        return userRepository.findByLogin(username)
    }

    companion object{
        fun authenticated(): User? {
            return try {
                SecurityContextHolder.getContext().authentication?.principal as? User
            }catch (e: Exception){
                null
            }
        }
    }
}