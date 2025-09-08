package com.aurora.webapi.modules.fichas.application.usecases.cor

import com.aurora.webapi.modules.fichas.CorDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.CorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.CorRepository
import org.springframework.stereotype.Service

@Service
class UpdateCor(
    private val corRepository: CorRepository
) {

    fun execute(id: Long, corDTO: CorDTO): CorEntity {
        val corFinded = corRepository.findById(id)
        val cor = CorEntity(
            id= id,
            nome = corDTO.nome,
            valorHexadecimal = corDTO.valorHex
        )
        return corRepository.save(cor)
    }
}