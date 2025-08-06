package com.aurora.webapi.modules.fichas.service.colecao

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.infra.entity.ColecaoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.AnoColecaoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.stereotype.Service

@Service
class AnoColecaoService(
    val colecaoRepository: AnoColecaoRepository
) : CrudService<AnoColecaoEntity>{

    override fun save(entity: AnoColecaoEntity ): AnoColecaoEntity {
        return colecaoRepository.save(entity)
    }

    override fun buscarPorId(id: Long): AnoColecaoEntity? {
        return colecaoRepository.findById(id).orElseThrow { throw EntityNotFoundException("colecao nao encontrada") }
    }

    override fun buscarTodos(): List<AnoColecaoEntity> {
        return colecaoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<AnoColecaoEntity> {
        return colecaoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        colecaoRepository.deleteById(id)
    }
    fun buscaPorAnoColecao(ano: String): AnoColecaoEntity {
        return colecaoRepository.findByAno(ano)
    }

}