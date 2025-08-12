package com.aurora.webapi.modules.fichas.service.artigo

import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.stereotype.Service

@Service
class ArtigoService (
    private val artigoRepository: ArtigoRepository
) : CrudService<ArtigoEntity> {

    override fun save(artigo: ArtigoEntity): ArtigoEntity {
        return artigoRepository.save(artigo)
    }

    override fun buscarPorId(id: Long): ArtigoEntity {
        return artigoRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Artigo com ID $id não encontrada") }
    }

    override fun buscarTodos(): List<ArtigoEntity> {
        return artigoRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<ArtigoEntity> {
        return artigoRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
        artigoRepository.deleteById(id)
    }
}