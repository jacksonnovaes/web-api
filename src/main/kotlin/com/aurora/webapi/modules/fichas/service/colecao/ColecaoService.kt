package com.aurora.webapi.modules.fichas.service.colecao

import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.ColecaoRepository
import org.springframework.stereotype.Service

@Service
class ColecaoService(
    val colecaoRepository: ColecaoRepository
) {
    fun salvarColecao(colecaoEntity: ColecaoEntity): ColecaoEntity {
        return colecaoRepository.save(colecaoEntity)
    }

    fun buscarPorId(id: Long): ColecaoEntity {
        return colecaoRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Lavagem com ID $id não encontrada") }
    }

    fun buscarTodos(): List<ColecaoEntity> {
        return colecaoRepository.findAll()
    }

    fun buscarPorIds(ids: List<Long>): List<ColecaoEntity> {
        return colecaoRepository.findAllById(ids)
    }

    fun deletar(id: Long) {
        colecaoRepository.deleteById(id)
    }
}