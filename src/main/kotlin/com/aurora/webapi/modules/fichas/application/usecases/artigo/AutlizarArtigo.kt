package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import org.springframework.stereotype.Service

@Service
class  AutlizarArtigo(
    val artigoService: ArtigoService

) {

    fun execute(artigoDTO: ArtigoDTO): ArtigoResponseDTO{
        artigoService.buscarPorId(artigoDTO.id!!)
        val artigo = ArtigoConverter.toEntity(artigoDTO)
        return ArtigoConverter.toDTO(artigoService.save(artigo))
    }

}