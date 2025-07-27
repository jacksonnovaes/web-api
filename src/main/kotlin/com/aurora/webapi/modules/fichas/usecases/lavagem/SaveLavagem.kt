package com.aurora.webapi.modules.fichas.usecases.lavagem

import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.stereotype.Service

@Service
class SaveLavagem(
    val lavagemRepository: LavagemRepository
) {

    fun execute(lavagenDTO: LavagenDTO): LavagenEntity {


        val lavagem = LavagenEntity(
            id = null,
            descricao = lavagenDTO.descricao,
            code = lavagenDTO.code,
            imagem = lavagenDTO.imagem

        )
        return lavagemRepository.save(lavagem)
    }
}