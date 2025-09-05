package com.aurora.webapi.modules.fichas.domain

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum

data class Artigo(
    val id: Long? = null,
    val nome: String,
    val status: StatusEnum?,
    val instrucionsIds: List<Long>? = emptyList(),
    val categoriaId: Long?
)
fun Artigo.toEntity() = ArtigoEntity(
    id = this.id,
    nome = this.nome,
    status = this.status,
    instrucions = this.instrucionsIds,
    categoria = this.categoriaId
)