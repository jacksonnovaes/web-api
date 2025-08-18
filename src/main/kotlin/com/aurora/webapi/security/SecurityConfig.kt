package com.aurora.webapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    val securityFilter: SecurityFilter
) {

    val PUBLIC_MATCHERS = arrayOf(
        "/login",
        "/v3/api-docs/**",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/h2/**",
        "/v1/fichas/remove/**",
        "/v1/fichas/save/**",
        "/v1/fichas/list/**",
        "/v1/fichas/update/**",
        "/api/v1/lavagem/**",
        "/v1/artigos/remove/**",
        "/v1/artigos/atualizar/**",
        "/v1/artigos/list/**",
        "/v1/artigos/save/**",
        "/v1/colecao/**",
        "/v1/composicao/**",
        "/v1/fornecedor/**",
        "/v1/categoria/**",
        "/v1/lavagem/**",
        "/v1/lavagem/multiple/**",
        "/v1/lavagemCategoria/**",
        "/v1/anoColecao/**"

    )

    val ADMIN_MATCHERS = arrayOf(
        "/"
    )

    val EMPLOYEE_MATCHERS = arrayOf(
        "/"
    )
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors { it.configurationSource(apiConfigurationSource()) }
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers(*PUBLIC_MATCHERS).permitAll()
                    .requestMatchers(*ADMIN_MATCHERS).hasRole("")
                    .requestMatchers(*EMPLOYEE_MATCHERS).hasRole("")
                    .anyRequest().authenticated()
            }
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter::class.java)
            .headers { it.frameOptions { frame -> frame.sameOrigin() } }
            .build()
    }

    @Bean
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager {
        return configuration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun apiConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration().apply {
            allowedOrigins = listOf(
                "http://localhost:8080",
                "http://localhost:3000",
                "http://https://aurora-theta-six.vercel.app",
                "https://aurora-theta-six.vercel.app"
              )
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
            allowedHeaders = listOf("*")
            allowCredentials = true
            allowedOriginPatterns = listOf("*")
        }

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

}