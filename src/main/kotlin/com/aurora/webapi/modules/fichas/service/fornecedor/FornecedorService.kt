package com.aurora.webapi.modules.fichas.service.fornecedor

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FornecedorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FornecedorService(
    val fornecedorRepository: FornecedorRepository
): CrudService<FornecedorEntity> {



    override fun save(entity: FornecedorEntity): FornecedorEntity {
         return fornecedorRepository.save(entity)
    }

    override fun buscarPorId(id: Long): FornecedorEntity? {
        return fornecedorRepository.findById(id)
            .orElseThrow{throw EntityNotFoundException("fornecedor nao encontrada")}
    }

    override fun buscarTodos(pageable: Pageable): Page<FornecedorEntity> {
        return fornecedorRepository.findAll(pageable)
    }

    override fun buscarTodos(): List<FornecedorEntity> {
        return fornecedorRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<FornecedorEntity> {
          return  fornecedorRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
       fornecedorRepository.deleteById(id)
    }

    override fun buscarPorNomeDescricao(
        termo: String,
        status: String,
        pageable: Pageable
    ): Page<FornecedorEntity> {
        TODO("Not yet implemented")
    }
}