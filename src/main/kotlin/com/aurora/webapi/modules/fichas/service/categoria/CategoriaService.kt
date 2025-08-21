package com.aurora.webapi.modules.fichas.service.categoria

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.CategoriaEntity
import com.aurora.webapi.modules.fichas.infra.repositories.CategoriaRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) : CrudService<CategoriaEntity>{

    override fun save(entity: CategoriaEntity): CategoriaEntity {
        return categoriaRepository.save(entity)
    }

    override fun buscarPorId(id: Long): CategoriaEntity? {
        return categoriaRepository.findById(id).orElseThrow { throw EntityNotFoundException("colecao nao encontrada") }
    }

    override fun buscarTodos(pageable: Pageable): Page<CategoriaEntity> {
        return categoriaRepository.findAll(pageable)
    }

    override fun buscarTodos(): List<CategoriaEntity> {
        return categoriaRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<CategoriaEntity> {
        return categoriaRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        categoriaRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<CategoriaEntity> {
        TODO("Not yet implemented")
    }
}