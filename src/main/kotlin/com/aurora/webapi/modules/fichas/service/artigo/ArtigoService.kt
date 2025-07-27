package com.aurora.webapi.modules.fichas.service.artigo

import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import org.springframework.stereotype.Service

@Service
class ArtigoService(
    val artigoRepository: ArtigoRepository
) {
    fun salvarLavagen(lavagen: ArtigoEntity): ArtigoEntity {
        return artigoRepository.save(lavagen)
    }

    fun buscarPorId(id: Long): ArtigoEntity {
        return artigoRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Lavagem com ID $id não encontrada") }
    }

    fun buscarTodos(): List<ArtigoEntity> {
        return artigoRepository.findAll()
    }

    fun buscarPorIds(ids: List<Long>): List<ArtigoEntity> {
        return artigoRepository.findAllById(ids)
    }

    fun deletar(id: Long) {
        artigoRepository.deleteById(id)
    }
}