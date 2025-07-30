package com.aurora.webapi.modules.fichas.service.composicao

import com.aurora.webapi.modules.fichas.infra.entity.ComposicaoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ComposicaoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
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

    override fun buscarTodos(): List<ComposicaoEntity> {
        return composicaoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ComposicaoEntity> {
        return composicaoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        composicaoRepository.deleteById(id)
    }
}