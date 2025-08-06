package com.aurora.webapi.modules.fichas.usecases.lavagem

import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.stereotype.Service

@Service
class ListLavagem(
    val lavagemRepository: LavagemRepository
) {

    fun execute(): List<LavagenEntity>{
        return lavagemRepository.findAll()
    }
}