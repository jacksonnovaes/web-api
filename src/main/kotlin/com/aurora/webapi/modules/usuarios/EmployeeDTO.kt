package com.aurora.webapi.modules.usuarios

data class EmployeeDTO(
    val id: Long? = 0L,
    val nome: String,
    val lastName: String,
    val documentId: String
)
