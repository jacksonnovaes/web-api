package com.aurora.webapi.modules.fichas.service.ficha

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import org.springframework.stereotype.Service

@Service
class FichaService(
    val fichaRepository: FichaRepository
) {

    fun saveFicha(ficha: FichaDTO): FichaEntity {
        val fichaEntity = FichaConverter.toEntity(ficha = ficha)
        return fichaRepository.save(fichaEntity)
    }
    fun updateFicha(ficha: FichaDTO): FichaEntity {
        val fichaEntity = FichaConverter.toEntity(ficha = ficha)
        return fichaRepository.save(fichaEntity)
    }
}