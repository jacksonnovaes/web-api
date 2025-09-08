package com.aurora.webapi.modules.fichas.application.usecases.fichas

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.toDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.toEntity
import org.springframework.stereotype.Service

@Service
class SaveFicha(
    val fichaRepository: FichaRepository

) {
    fun execute(fichaDTO: FichaDTO): FichaDTO {

        return try {
           fichaRepository.save(fichaDTO.toEntity()).toDTO()
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}