package com.aurora.webapi.modules.fichas.application.usecases.anoColecao.impl

import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.inbound.dto.AnoColecaoRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.AnoColecaoRepository
import com.aurora.webapi.modules.fichas.application.usecases.anoColecao.SaveAnoColecao
import com.aurora.webapi.modules.fichas.converter.AnoColecaoConverter
import org.springframework.stereotype.Service

@Service
class SaveAnoColecaoImpl(
        val anoColecaoRepository: AnoColecaoRepository
): SaveAnoColecao {

    override fun execute(anoColecaoDTO: AnoColecaoRequestDTO): AnoColecaoResponseDTO {
        val colecao = AnoColecaoConverter.toEntity(anoColecaoDTO)
        val colecaoDTO = AnoColecaoConverter.toDTO(anoColecaoRepository.save(colecao))
        return  colecaoDTO
    }
}