package com.aurora.webapi.modules.usuarios.infra.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name ="tb_usuario")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    val id: Long? = null,
    val login: String,
    val pass: String,
    val roles: Set<String>? = emptySet()

): UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))

        roles?.forEach { role ->
            authorities.add(SimpleGrantedAuthority("ROLE_$role"))
        }
        return authorities
    }

    override fun getPassword(): String? {
       return pass
    }

    override fun getUsername(): String? {
      return login
    }

}