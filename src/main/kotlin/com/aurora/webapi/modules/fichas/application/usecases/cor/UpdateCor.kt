package com.aurora.webapi.modules.fichas.application.usecases.cor

import com.aurora.webapi.modules.fichas.CorDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.service.cor.CorService
import org.springframework.stereotype.Service

@Service
class UpdateCor(
    private val corService: CorService
) {

    fun execute(id: Long, corDTO: CorDTO): CorEntity {
        val corFinded = corService.buscarPorId(id)
        val cor = CorEntity(
            id= id,
            nome = corDTO.nome,
            valorHexadecimal = corDTO.valorHex
        )
        return corService.save(cor)
    }
}