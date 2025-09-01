package com.aurora.webapi.modules.fichas.application.usecases.colecao

import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.stereotype.Service

@Service
class RemoveColecao(
    val colecaoService: ColecaoService
) {

    fun execute(id: Long){
       val savedColecao = colecaoService.deletar(id)
        print(savedColecao)
    }
}