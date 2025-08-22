package com.aurora.webapi.modules.fichas.usecases.lavagem

import com.aurora.webapi.modules.fichas.infra.entity.LavagemEntity
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ListLavagem(
    val lavagemRepository: LavagemRepository
) {
    @Transactional
    fun execute(): List<LavagemEntity>{
        return lavagemRepository.findAll()
    }
}