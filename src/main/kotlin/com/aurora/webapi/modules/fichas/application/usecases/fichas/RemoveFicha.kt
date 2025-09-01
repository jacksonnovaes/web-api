package com.aurora.webapi.modules.fichas.application.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.ficha.FichaService
import org.springframework.stereotype.Service

@Service
class RemoveFicha(
    val fIchaService: FichaService
) {
    fun execute(id: Long, ) {
        val ficha = fIchaService.buscarPorId(id)
            ?: throw RuntimeException("Ficha não encontrada")
        if(ficha.status.equals(StatusEnum.INACTIVE)){
            throw RuntimeException("Ficha ja foi removida")
        }
        val fichaDTO = FichaDTO(
            id = ficha.id,
            numeroFicha = ficha.numeroFicha.toInt(),
            notaFiscal = ficha.notaFiscal.toInt(),
            dataEntrada = ficha.dataEntrada,
            largura = ficha.largura,
            artigoId = ficha.artigo.id,
            artigo = ficha.artigo.nome,
            colecaoId = ficha.colecao.id,
            anoColecaoId = ficha.colecao.anoCoelecao?.id,
            composicaoId = ficha.composicao.id,
            fornecedorId = ficha.fornecedor.id,
            status = StatusEnum.INACTIVE.value
        )
        FichaConverter.toDTO(fIchaService.save(FichaConverter.toEntity(fichaDTO)))
    }

}