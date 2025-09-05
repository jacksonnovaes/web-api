package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.domain.Artigo
import com.aurora.webapi.modules.fichas.domain.toEntity
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import org.springframework.stereotype.Service

@Service
class  AutlizarArtigo(
    val artigoService: ArtigoService
) {

    fun execute(artigo: Artigo): Artigo{
        artigoService.buscarPorId(artigo.id!!)
        return artigoService.save(artigo.toEntity())
    }

}