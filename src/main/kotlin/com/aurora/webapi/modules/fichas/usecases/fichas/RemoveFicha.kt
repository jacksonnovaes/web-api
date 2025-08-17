package com.aurora.webapi.modules.fichas.usecases.fichas

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.ficha.FichaService
import org.springframework.stereotype.Service

@Service
class RemoveFicha(
    val fIchaService: FichaService
) {
    fun execute(id: Long) {
        fIchaService.buscarPorId(id)
            ?: throw RuntimeException("Ficha não encontrada") // evita null

        return try {
            fIchaService.deletar(id)
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}