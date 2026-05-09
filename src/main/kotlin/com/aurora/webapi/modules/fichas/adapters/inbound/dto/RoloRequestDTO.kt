package com.aurora.webapi.modules.fichas.adapters.inbound.dto

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum

data class RoloRequestDTO(
    val id: Long? = null,
    val codigo: Long,
    val localizacao: String,
    val valorMedida: Float, // kg ou mts
    val typeMedida: String,
    val quantidade: Float,
    val rendimento: Float,
    val corId: Long,
    val fichaId: Long,
    val status: StatusEnum
)
