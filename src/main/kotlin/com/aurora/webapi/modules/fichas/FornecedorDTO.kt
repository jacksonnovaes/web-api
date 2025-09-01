package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FichaEntity

data class FornecedorDTO(

    val id: Long? = null,
    val nome: String,
    val fichas: List<FichaEntity>?,

    ){
        companion object {
            fun onlyId(id: Long?) = FornecedorDTO(id, "", emptyList())
        }
    }

