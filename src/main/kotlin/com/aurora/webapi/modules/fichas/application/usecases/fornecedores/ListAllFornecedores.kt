package com.aurora.webapi.modules.fichas.application.usecases.fornecedores

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import com.aurora.webapi.modules.fichas.converter.FornecedorConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ListAllFornecedores(
    val fornecedorRepository: FornecedorRepository
){
    fun execute(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<FornecedorDTO> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        val listAllFornecedores = fornecedorRepository.findAll(statusEnum = StatusEnum.ACTIVE,pageRequest)
            .map {
                FornecedorConverter.toDTO(it)
            }

        return listAllFornecedores
    }

}