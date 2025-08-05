package com.aurora.webapi.modules.fichas.usecases.lavagem

import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaLagamRepository
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.stereotype.Service

@Service
class SaveLavagem(
    val lavagemRepository: LavagemRepository,
    val categoriaLagamRepository: CategoriaLagamRepository
) {
    fun execute(lavagenDTO: LavagenDTO): LavagenEntity {
        val categoria = lavagenDTO.lavagemCategoriaID?.let { id ->
            categoriaLagamRepository.findById(id).orElseGet {
                // Se não encontrar, salva uma nova categoria com o ID e descricao vazia
                categoriaLagamRepository.save(
                    CategoriaLavagemEntity(
                        id = id,
                        descricao = lavagenDTO.descricao // ou defina um valor padrão se quiser
                    )
                )
            }
        }

        val lavagem = LavagenEntity(
            id = null,
            descricao = lavagenDTO.descricao,
            code = lavagenDTO.code,
            imagem = lavagenDTO.imagem,
            categoria = categoria
        )

        return lavagemRepository.save(lavagem)
    }

}