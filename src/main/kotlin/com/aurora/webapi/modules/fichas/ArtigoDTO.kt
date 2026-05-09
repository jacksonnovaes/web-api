package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.domain.Artigo
import jakarta.validation.constraints.NotBlank

data class ArtigoDTO(
    val id: Long? = null,
    @NotBlank
    val nome: String,
    val instrucoes: List<Long>? = emptyList(),
    val categoriaId: Long?,
    val status: String?
){
    companion object {
        fun onlyId(id: Long?) = ArtigoDTO(id, "", emptyList(), categoriaId = null, status = null)
    }

    fun toDomain(): Artigo {
        return Artigo(
            id = this.id,
            nome = this.nome,
            status = StatusEnum.fromValue(this.status),
            instrucionsIds = this.instrucoes,
            categoriaId = this.categoriaId
        )
    }
}
