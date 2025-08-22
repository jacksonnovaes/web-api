package com.aurora.webapi.modules.fichas.usecases.anoColecao

import com.aurora.webapi.modules.fichas.AnoColecaoDTO
import com.aurora.webapi.modules.fichas.AnoColecaoResponseDTO
import com.aurora.webapi.modules.fichas.converter.AnoColecaoConverter
import com.aurora.webapi.modules.fichas.service.colecao.AnoColecaoService
import org.springframework.stereotype.Service

@Service
class SaveAnoColecao(
        val anoColecaoService: AnoColecaoService
) {

    fun execute(anoColecaoDTO: AnoColecaoDTO): AnoColecaoResponseDTO {
        val colecao = AnoColecaoConverter.toEntity(anoColecaoDTO)
        val colecaoDTO = AnoColecaoConverter.toDTO(anoColecaoService.save(colecao))
        return  colecaoDTO
    }
}