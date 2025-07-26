package com.aurora.webapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
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
        "/api/v1/address/**",
        "/api/v1/product/**",
        "/api/v1/product/menu/**",
        "/api/v1/payment/**",
        "/api/v1/signup/**",
        "/api/v1/customer/signup/save",
        "/efi/v2/cob/pix/**",
        "/api/v1/payment/loc/**",
        "/api/v1/pdv/config/**",
        "/efi/v1/payment/pix",
        "/api/v1/fornecedores/**"
    )

    val APUBLIC_MATCHERS = arrayOf(
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
                 //   .requestMatchers(*APUBLIC_MATCHERS).authenticated()
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