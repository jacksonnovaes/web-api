package com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl

import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.AnoColecaoRequestDTO
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.SaveAnoColecao
import com.aurora.webapi.modules.fichas.converter.AnoColecaoConverter
import com.aurora.webapi.modules.fichas.service.colecao.AnoColecaoService
import org.springframework.stereotype.Service

@Service
class SaveAnoColecaoImpl(
        val anoColecaoService: AnoColecaoService
): SaveAnoColecao {

    override fun execute(anoColecaoDTO: AnoColecaoRequestDTO): AnoColecaoResponseDTO {
        val colecao = AnoColecaoConverter.toEntity(anoColecaoDTO)
        val colecaoDTO = AnoColecaoConverter.toDTO(anoColecaoService.save(colecao))
        return  colecaoDTO
    }
}