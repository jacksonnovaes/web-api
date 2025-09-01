package com.aurora.webapi.modules.fichas.application.usecases.fichas

import com.aurora.webapi.modules.fichas.FichaReponseDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.converter.FichaConverter
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
        val findAll = fichaRepository.findAllFichas(StatusEnum.ACTIVE.name, pageRequest)
        val listAllFichas = findAll
            .map {
                FichaConverter.toResponseDTO(it)
            }

        return listAllFichas
    }

}