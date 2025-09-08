package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import com.aurora.webapi.modules.fichas.domain.Artigo
import org.springframework.stereotype.Service

@Service
class  AutlizarArtigo(
    val artigoRepository: ArtigoRepository
) {

    fun execute(artigo: Artigo): Artigo{
        artigoRepository.findById(artigo.id!!)
        return artigoRepository.save(artigo)
    }

}