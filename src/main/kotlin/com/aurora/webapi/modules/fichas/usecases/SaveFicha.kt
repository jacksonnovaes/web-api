package com.aurora.webapi.modules.fichas.usecases

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.FichaService
import org.springframework.stereotype.Service

@Service
class SaveFicha(
    val fIchaService: FichaService
) {
    fun execute(fichaDTO: FichaDTO): FichaDTO {

        return FichaConverter.toDTO(fIchaService.saveFicha(fichaDTO))
    }
}