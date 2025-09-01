package com.aurora.webapi.modules.fichas.application.usecases.artigo

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.ArtigoResponseDTO
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.service.artigo.ArtigoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class SaveArtigo(
    val artigoService: ArtigoService
) {
    @Transactional
    fun execute(@Valid artigoDTO: ArtigoDTO): ArtigoResponseDTO {
                val artigo = ArtigoConverter.toEntity(artigoDTO)
        return ArtigoConverter.toDTO(artigoService.save(artigo))
    }
}