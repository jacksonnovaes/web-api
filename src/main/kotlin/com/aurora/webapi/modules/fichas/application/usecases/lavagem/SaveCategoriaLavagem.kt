package com.aurora.webapi.modules.fichas.application.usecases.lavagem

import com.aurora.webapi.modules.fichas.CategoriaLavagenDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.service.lavagem.CategoriaLagameService
import org.springframework.stereotype.Service

@Service
class SaveCategoriaLavagem(

    val categoriaLagameService: CategoriaLagameService
) {

    fun execute(categoriaLavagenDTO: CategoriaLavagenDTO): CategoriaLavagemEntity{
            val categoriaLavagem = CategoriaLavagemEntity(
                id = categoriaLavagenDTO.id,
                descricao = categoriaLavagenDTO.descricao
            )
            return categoriaLagameService.save(categoriaLavagem)

    }
}