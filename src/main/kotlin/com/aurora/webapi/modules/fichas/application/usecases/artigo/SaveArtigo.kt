package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.artigo.ArtigoRepository
import com.aurora.webapi.modules.fichas.domain.Artigo
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class SaveArtigo(
    val artigoRepository: ArtigoRepository
) {
    @Transactional
    fun execute(@Valid artigoDTO: ArtigoDTO): Artigo {
                val artigo = artigoDTO.toDomain()
        return artigoRepository.save(artigo)
    }
}