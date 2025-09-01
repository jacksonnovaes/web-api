package com.aurora.webapi.modules.usuarios.infra.entity

import jakarta.persistence.*
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
    val name: String,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = [JoinColumn(name = "user_id")])
    val roles: Set<Role>? = emptySet()
    ): UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
        authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))

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