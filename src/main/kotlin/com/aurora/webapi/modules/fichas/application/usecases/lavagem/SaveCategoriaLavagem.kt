package com.aurora.webapi.modules.fichas.application.usecases.lavagem

import com.aurora.webapi.modules.fichas.CategoriaLavagenDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CategoriaLagamRepository
import org.springframework.stereotype.Service

@Service
class SaveCategoriaLavagem(

    val categoriaLagamRepository: CategoriaLagamRepository
) {

    fun execute(categoriaLavagenDTO: CategoriaLavagenDTO): CategoriaLavagemEntity{
            val categoriaLavagem = CategoriaLavagemEntity(
                id = categoriaLavagenDTO.id,
                descricao = categoriaLavagenDTO.descricao
            )
            return categoriaLagamRepository.save(categoriaLavagem)

    }
}