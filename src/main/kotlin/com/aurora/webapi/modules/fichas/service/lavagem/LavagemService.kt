package com.aurora.webapi.modules.fichas.service.lavagem

import com.aurora.webapi.modules.fichas.infra.entity.LavagemEntity
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class LavagenService(
    private val lavagenRepository: LavagemRepository
) {

    fun salvarLavagen(lavagen: LavagemEntity): LavagemEntity {
        return lavagenRepository.save(lavagen)
    }

    fun buscarPorId(id: Long): LavagemEntity {
        return lavagenRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Lavagem com ID $id não encontrada") }
    }

    fun buscarTodos(): List<LavagemEntity> {
        return lavagenRepository.findAll()
    }

    fun buscarPorIds(ids: List<Long>): List<LavagemEntity> {
        return lavagenRepository.findAllById(ids)
    }

    fun deletar(id: Long) {
        lavagenRepository.deleteById(id)
    }
}