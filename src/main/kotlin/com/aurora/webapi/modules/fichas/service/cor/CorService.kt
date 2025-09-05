package com.aurora.webapi.modules.fichas.service.cor

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CorRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service

class CorService (
    private val corRepository: CorRepository
) : CrudService<CorEntity> {
    @Transactional
    override fun save(entity: CorEntity): CorEntity {
        return corRepository.save(entity)
    }

    override fun buscarPorId(id: Long): CorEntity {
        return corRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Artigo com ID $id não encontrada") }
    }

    override fun buscarTodos(pageable: Pageable): Page<CorEntity> {
        return corRepository.findAll(pageable)
    }

    override fun buscarTodos(): List<CorEntity> {
        return corRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<CorEntity> {
        return corRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        corRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<CorEntity> {
        return corRepository.findByNome(termo,pageable)
    }


}