package com.aurora.webapi.modules.fichas.service.lavagem

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaLavagemEntity
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaLagamRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoriaLagameService(
    private val categoriaLagamRepository: CategoriaLagamRepository
): CrudService<CategoriaLavagemEntity> {
    override fun save(entity: CategoriaLavagemEntity): CategoriaLavagemEntity {
        return categoriaLagamRepository.save(entity)
    }

    override fun buscarPorId(id: Long): CategoriaLavagemEntity? {
        return categoriaLagamRepository.findById(id)
            .orElseThrow{throw EntityNotFoundException("instrucao nao encontrada")}

    }

    override fun buscarTodos(pageable: Pageable): Page<CategoriaLavagemEntity> {
        return categoriaLagamRepository.findAll(pageable)
    }

    override fun buscarTodos(): List<CategoriaLavagemEntity> {
        return categoriaLagamRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<CategoriaLavagemEntity> {
        return categoriaLagamRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        categoriaLagamRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<CategoriaLavagemEntity> {
        TODO("Not yet implemented")
    }
}