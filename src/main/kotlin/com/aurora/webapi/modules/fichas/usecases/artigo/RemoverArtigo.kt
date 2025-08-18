package com.aurora.webapi.modules.fichas.usecases.artigo

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.LavagenDTO
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import org.springframework.stereotype.Service

@Service
class  RemoverArtigo(
    val artigoService: ArtigoService

) {

    fun execute(id: Long){
        val artigo = artigoService.buscarPorId(id)

        val artigoDTO = ArtigoDTO(
            id = artigo.id,
            nome = artigo.nome,
            instrucoes = artigo.instrucions?.map { it.id } as List<Long?>,
            categoriaId = artigo.categotia.id,
            status = StatusEnum.INACTIVE
        )
        artigoService.save(ArtigoConverter.toEntity(artigoDTO))
    }

}