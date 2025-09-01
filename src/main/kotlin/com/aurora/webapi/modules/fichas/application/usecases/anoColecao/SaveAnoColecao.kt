package com.aurora.webapi.modules.fichas.application.usecases.anoColecao

import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.AnoColecaoRequestDTO

interface SaveAnoColecao {
    fun execute(anoColecaoDTO: AnoColecaoRequestDTO): AnoColecaoResponseDTO
}