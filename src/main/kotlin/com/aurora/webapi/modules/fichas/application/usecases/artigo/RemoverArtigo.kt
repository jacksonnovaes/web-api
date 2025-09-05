package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.ArtigoEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import org.springframework.stereotype.Service

@Service
class  RemoverArtigo(
    val artigoService: ArtigoService

) {

    fun execute(id: Long){
        val artigo = artigoService.buscarPorId(id)

        val artigoDTO = ArtigoEntity(
            id = artigo.id,
            nome = artigo.nome,
            instrucions = artigo.instrucionsIds?.map { it },
            categoria = artigo.categoriaId,
            status = StatusEnum.INACTIVE
        )
        artigoService.save(artigoDTO)
    }

}