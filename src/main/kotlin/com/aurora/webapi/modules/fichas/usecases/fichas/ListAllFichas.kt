package com.aurora.webapi.modules.fichas.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListAllFichas(
    val fichaRepository: FichaRepository
){
    fun execute(page: Int, linesPerPge: Int, orderBy: String, direction: String): Page<FichaReponseDTO> {
        val pageRequest = PageRequest.of(page, linesPerPge, Sort.Direction.valueOf(direction), orderBy);
        val listAllFichas = fichaRepository.findAll(pageRequest)
            .map {
                FichaConverter.toResponseDTO(it)
            }

        return listAllFichas
    }

}