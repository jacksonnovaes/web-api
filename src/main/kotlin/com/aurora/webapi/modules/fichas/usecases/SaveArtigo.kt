package com.aurora.webapi.modules.fichas.usecases

import com.aurora.webapi.modules.fichas.ArtigoDTO
import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.converter.ArtigoConverter
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.service.ArtigoService
import com.aurora.webapi.modules.fichas.service.FichaService
import org.springframework.stereotype.Service

@Service
class SaveArtigo(
    val artigoService: ArtigoService
) {
    fun execute(artigoDTO: ArtigoDTO): ArtigoDTO {

        return ArtigoConverter.toDTO(artigoService.saveArtigo(artigoDTO))
    }
}