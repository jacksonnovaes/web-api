package com.aurora.webapi.modules.config


import com.aurora.webapi.exceptions.AuthorizationException
import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.exceptions.StandardError
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackages = ["com.aurora.webapi.modules"])
class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun notFound404(ex: EntityNotFoundException): ResponseEntity<Void> {
        val err = StandardError(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            System.currentTimeMillis(),
            null
        )
        return ResponseEntity.notFound().build()
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun badRequest400(ex: MethodArgumentNotValidException): ResponseEntity<List<ErrorValidationData>> {
        val list = ex.fieldErrors
        return ResponseEntity.badRequest().body(list.map { ErrorValidationData(it) })
    }

    @ExceptionHandler(DataIntegrityException::class)
    fun dataIntegrity(ex: DataIntegrityException,req: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            System.currentTimeMillis(),
            req.requestURI
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err)
    }

    data class ErrorValidationData(val field: String?, val message: String?) {
        constructor(error: FieldError) : this(error.field, error.defaultMessage)
    }

    @ExceptionHandler(AuthorizationException::class)
    fun authorization(e: AuthorizationException, req: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(
            HttpStatus.FORBIDDEN.value(),
            e.message,
            System.currentTimeMillis(),
            req.requestURI
        )
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err)
    }


    @ExceptionHandler(AuthenticationException::class)
    fun handleUnauthorized(ex: AuthenticationException, req: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(
            HttpStatus.UNAUTHORIZED.value(),
            "Acesso não autorizado. Verifique suas credenciais.",
            System.currentTimeMillis(),
            req.requestURI
        )
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err)
    }
}
