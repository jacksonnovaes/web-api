package com.aurora.webapi.modules.fichas.application.usecases.colecao

import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ColecaoRepository

import org.springframework.stereotype.Service

@Service
class RemoveColecao(
    val colecaoRepository: ColecaoRepository
) {

    fun execute(id: Long){
       val savedColecao = colecaoRepository.findById(id)
        print(savedColecao)
    }
}