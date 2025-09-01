package com.aurora.webapi.modules.fichas.application.usecases.lavagem

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.LavagemEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.LavagemRepository
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