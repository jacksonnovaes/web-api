package com.aurora.webapi.modules.fichas.service.ficha

import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.service.CrudService
import org.springframework.stereotype.Service

@Service
class FichaService(
    val fichaRepository: FichaRepository
): CrudService<FichaEntity> {



    override fun save(entity: FichaEntity): FichaEntity {
         return fichaRepository.save(entity)
    }

    override fun buscarPorId(id: Long): FichaEntity? {
        return fichaRepository.findById(id)
            .orElseThrow{throw EntityNotFoundException("ficha nao encontrada")}
    }

    override fun buscarTodos(): List<FichaEntity> {
        return fichaRepository.findAll()
    }

    override fun buscarPorIds(ids: List<Long>): List<FichaEntity> {
          return  fichaRepository.findAllById(ids)
    }

    override fun deletar(id: Long) {
       fichaRepository.deleteById(id)
    }
}