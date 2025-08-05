package com.aurora.webapi.modules.fichas.service.fornecedor

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.service.CrudService
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

    override fun buscarTodos(): List<FornecedorEntity> {
        return fornecedorRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<FornecedorEntity> {
          return  fornecedorRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
       fornecedorRepository.deleteById(id)
    }
}