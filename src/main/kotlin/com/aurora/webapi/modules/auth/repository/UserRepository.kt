package com.aurora.webapi.modules.auth.repository

import com.aurora.webapi.modules.usuarios.infra.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByLogin(userName: String): User

}