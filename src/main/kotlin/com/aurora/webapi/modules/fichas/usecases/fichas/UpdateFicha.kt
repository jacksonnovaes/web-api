package com.aurora.webapi.modules.fichas.usecases.fichas

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.ficha.FichaService
import org.springframework.stereotype.Service

@Service
class UpdateFicha(
    val fIchaService: FichaService
) {
    fun execute(fichaDTO: FichaDTO, id: Long): FichaDTO {
        val existingFicha = fIchaService.buscarPorId(id)
            ?: throw RuntimeException("Ficha não encontrada") // evita null

        return try {
            FichaConverter.toDTO(fIchaService.save(FichaConverter.toEntity(fichaDTO)))
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}