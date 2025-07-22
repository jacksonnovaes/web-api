package com.aurora.webapi.modules.fichas

import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity

data class FornecedorDTO(

    val id: Long? = null,
    val nome: String,
    val fichas: List<FichaEntity>,

    )
