package com.aurora.webapi.modules.fichas.usecases.colecao

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.converter.ColecaoConverter
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.stereotype.Service

@Service
class SaveColecao(
    val colecaoService: ColecaoService
) {

    fun execute(colecaoDTO: ColecaoDTO): ColecaoDTO{
        val colecao = ColecaoConverter.toEntity(colecaoDTO)
        val colecaoDTO = ColecaoConverter.toDomain(colecaoService.salvarColecao(colecao))
        return  colecaoDTO
    }
}