package com.aurora.webapi.modules.fichas.service.lavagem

import com.aurora.webapi.modules.fichas.infra.entity.LavagenEntity
import com.aurora.webapi.modules.fichas.infra.repositories.LavagemRepository
import org.springframework.stereotype.Service

@Service
class LavagenService(
    private val lavagenRepository: LavagemRepository
) {

    fun salvarLavagen(lavagen: LavagenEntity): LavagenEntity {
        return lavagenRepository.save(lavagen)
    }

    fun buscarPorId(id: Long): LavagenEntity {
        return lavagenRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Lavagem com ID $id não encontrada") }
    }

    fun buscarTodos(): List<LavagenEntity> {
        return lavagenRepository.findAll()
    }

    fun buscarPorIds(ids: List<Long>): List<LavagenEntity> {
        return lavagenRepository.findAllById(ids)
    }

    fun deletar(id: Long) {
        lavagenRepository.deleteById(id)
    }
}