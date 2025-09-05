package com.aurora.webapi.modules.fichas.service.composicao

import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ComposicaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.ComposicaoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class composicaoService (
    val composicaoRepository: ComposicaoRepository
): CrudService<ComposicaoEntity> {
    override fun save(entity: ComposicaoEntity): ComposicaoEntity {
       return composicaoRepository.save(entity)
    }

    override fun buscarPorId(id: Long): ComposicaoEntity? {
        return composicaoRepository.findById(id).orElseThrow()
    }

    override fun buscarTodos(pageable: Pageable): Page<ComposicaoEntity> {
        return composicaoRepository.findAll(pageable)
    }

    override fun buscarTodos(): List<ComposicaoEntity> {
        return composicaoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ComposicaoEntity> {
        return composicaoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        composicaoRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<ComposicaoEntity> {
        TODO("Not yet implemented")
    }
}