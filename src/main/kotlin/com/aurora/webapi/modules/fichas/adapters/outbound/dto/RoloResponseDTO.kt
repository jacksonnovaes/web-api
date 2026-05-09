package com.aurora.webapi.modules.fichas.adapters.outbound.dto


data class RoloResponseDTO(
    val id: Long? = null,
    val codigo: Long,
    val localizacao: String,
    val tipoMedida: String,
    val cor: String,
    val fichaId: Long,
    val status: String
)

data class CorResponseDTO(
    val cor: String
)