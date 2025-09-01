package com.aurora.webapi.modules.fichas.adapters.inbound.dto

data class AnoColecaoRequestDTO(
    val id: Long?=null,
    val nome: String = "",
) {

    companion object {
        fun onlyId(id: Long?) = AnoColecaoRequestDTO(id, "")

    }
}
data class AnoColecaoResponseDTO(
    val id: Long?=null,
    val ano: String = "",
)
