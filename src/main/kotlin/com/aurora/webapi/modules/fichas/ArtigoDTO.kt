package com.aurora.webapi.modules.fichas

import jakarta.validation.constraints.NotBlank

data class ArtigoDTO(
    val id: Long? = null,
    @NotBlank
    val nome: String,
    val instrucoes: List<Long?> = emptyList(),
    val categoriaId: Long?,
    val status: String?
){
    companion object {
        fun onlyId(id: Long?) = ArtigoDTO(id, "", emptyList(), categoriaId = null, status = null)
    }
}
