package com.aurora.webapi.modules.fichas.usecases.colecao

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.converter.ColecaoConverter
import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class RemoveColecao(
    val colecaoService: ColecaoService
) {

    fun execute(id: Long){
       val savedColecao = colecaoService.deletar(id)
        print(savedColecao)
    }
}