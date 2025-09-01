package com.aurora.webapi.modules.fichas.application.usecases.colecao

import com.aurora.webapi.modules.fichas.ColecaoDTO
import com.aurora.webapi.modules.fichas.ColecaoResponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.AnoColecaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ColecaoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.service.colecao.ColecaoService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UpdateColecao(
    val colecaoService: ColecaoService
) {

    fun execute(id: Long, colecaoDTO: ColecaoDTO): ColecaoResponseDTO{
        val colecao = colecaoService.buscarPorId(id)
       val savedColecao = colecaoService.save(
           ColecaoEntity(
               id = id,
               descricao = colecaoDTO.nome,
               anoCoelecao = AnoColecaoEntity(
                   id = colecaoDTO.anoColecaoId,
                   ano = colecao?.anoCoelecao?.ano ?: LocalDate.now().year.toString()
               ),
               fichas = emptyList(),
               status = StatusEnum.fromValue(colecaoDTO.status)!!
           )
       )
        return ColecaoResponseDTO(
            id = savedColecao.id,
            nome = savedColecao.descricao,
            ano = savedColecao.anoCoelecao?.ano,
            anoColecaoId = savedColecao.anoCoelecao?.id
        )
    }
}