package com.aurora.webapi.modules.auth.service

import com.aurora.webapi.modules.usuarios.infra.entity.User
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class UserService {

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