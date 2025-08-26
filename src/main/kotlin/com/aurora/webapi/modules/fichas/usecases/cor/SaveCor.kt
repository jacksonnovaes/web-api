package com.aurora.webapi.modules.fichas.usecases.cor

import com.aurora.webapi.modules.fichas.CorDTO
import com.aurora.webapi.modules.fichas.infra.entity.CorEntity
import com.aurora.webapi.modules.fichas.service.cor.CorService
import org.springframework.stereotype.Service

@Service
class SaveCor(
    private val corService: CorService
) {

    fun execute(corDTO: CorDTO): CorEntity {
        val cor = CorEntity(
            nome = corDTO.nome,
            valorHexadecimal = corDTO.valorHex
        )
        return corService.save(cor)
    }
}