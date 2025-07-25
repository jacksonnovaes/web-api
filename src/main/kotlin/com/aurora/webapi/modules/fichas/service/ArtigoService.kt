package com.aurora.webapi.modules.fichas.service

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.infra.entity.ArtigoEntity
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import com.aurora.webapi.modules.fichas.infra.repositories.ArtigoRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.usecases.SaveArtigo
import org.springframework.stereotype.Service

@Service
class ArtigoService(
    val artigoRepository: ArtigoRepository
) {

    fun saveArtigo(artigo: ArtigoDTO ): ArtigoEntity {
        val fichaEntity = ArtigoConverter.toEntity(entity = artigo)
        return artigoRepository.save(fichaEntity)
    }
}