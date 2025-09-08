package com.aurora.webapi.modules.fichas.application.usecases.colecao

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ColecaoRepository
import com.aurora.webapi.modules.fichas.converter.ColecaoConverter
import org.springframework.stereotype.Service

@Service
class SaveColecao(
    val colecaoRepository: ColecaoRepository
) {

    fun execute(colecaoDTO: ColecaoDTO): ColecaoResponseDTO{
        val colecao = ColecaoConverter.toEntity(colecaoDTO)
        val colecaoDTO = ColecaoConverter.toDTO(colecaoRepository.save(colecao))
        return  colecaoDTO
    }
}