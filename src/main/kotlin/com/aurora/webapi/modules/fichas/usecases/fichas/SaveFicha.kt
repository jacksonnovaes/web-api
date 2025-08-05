package com.aurora.webapi.modules.fichas.usecases.fichas

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.colecao.AnoColecaoService
import com.aurora.webapi.modules.fichas.service.ficha.FichaService
import org.springframework.stereotype.Service

@Service
class SaveFicha(
    val fIchaService: FichaService,
    val anoColecaoService: AnoColecaoService
) {
    fun execute(fichaDTO: FichaDTO): FichaDTO {

        return try {
            FichaConverter.toDTO(fIchaService.save(FichaConverter.toEntity(fichaDTO)))
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}