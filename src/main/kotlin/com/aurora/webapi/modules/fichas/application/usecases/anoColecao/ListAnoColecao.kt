package com.aurora.webapi.modules.fichas.application.usecases.anoColecao

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.AnoColecaoEntity

interface ListAnoColecao {
    fun execute(): List<AnoColecaoEntity>
}