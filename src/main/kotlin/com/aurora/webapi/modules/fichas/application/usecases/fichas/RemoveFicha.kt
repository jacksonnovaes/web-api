package com.aurora.webapi.modules.fichas.application.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.toEntity
import org.springframework.stereotype.Service

@Service
class RemoveFicha(
    val fichaRepository: FichaRepository
) {
    fun execute(id: Long, ) {
        val ficha = fichaRepository.findById(id).orElseThrow {
            throw RuntimeException("Ficha não encontrada")
        }
        if(ficha.status.equals(StatusEnum.INACTIVE)){
            throw RuntimeException("Ficha ja foi removida")
        }
        val fichaDTO = FichaDTO(
            id = ficha.id,
            numeroFicha = ficha.numeroFicha.toInt(),
            notaFiscal = ficha.notaFiscal.toInt(),
            dataEntrada = ficha.dataEntrada,
            largura = ficha.largura,
            artigoId = ficha.artigo,
            colecaoId = ficha.colecao,
            composicaoId = ficha.composicao,
            fornecedorId = ficha.fornecedor,
            status = StatusEnum.INACTIVE.value
        )
        fichaRepository.save(fichaDTO.toEntity())
    }

}