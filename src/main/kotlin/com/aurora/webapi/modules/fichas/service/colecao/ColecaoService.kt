package com.aurora.webapi.modules.fichas.service.colecao

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ColecaoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.stereotype.Service

@Service
class ColecaoService(
    val colecaoRepository: ColecaoRepository
) : CrudService<ColecaoEntity>{

    override fun save(colecaoEntity: ColecaoEntity): ColecaoEntity {
        return colecaoRepository.save(colecaoEntity)
    }

    override fun buscarPorId(id: Long): ColecaoEntity? {
        return colecaoRepository.findById(id).orElseThrow { throw EntityNotFoundException("colecao nao encontrada") }
    }

    override fun buscarTodos(): List<ColecaoEntity> {
        return colecaoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ColecaoEntity> {
        return colecaoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        colecaoRepository.deleteById(id)
    }
}