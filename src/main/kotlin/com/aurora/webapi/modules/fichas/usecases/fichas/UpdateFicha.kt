package com.aurora.webapi.modules.fichas.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.ficha.FichaService
import org.springframework.stereotype.Service

@Service
class UpdateFicha(
    val fIchaService: FichaService
) {
    fun execute(fichaDTO: FichaDTO, id: Long): FichaDTO {
        val ficha  = FichaConverter.toEntity(fichaDTO)
        return FichaConverter.toDTO(fIchaService.save(ficha))
    }
}