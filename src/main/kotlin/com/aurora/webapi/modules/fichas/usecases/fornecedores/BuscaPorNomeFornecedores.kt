package com.aurora.webapi.modules.fichas.usecases.fornecedores

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.converter.FornecedorConverter
import com.aurora.webapi.modules.fichas.enums.StatusEnum
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import org.springframework.data.domain.Page

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class BuscaPorNomeFornecedores(
    val fornecedorRepository: FornecedorRepository
){
    fun execute(nome: String, page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<FornecedorDTO> {

        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        val listAllFornecedores = fornecedorRepository.findByNome(nome, statusEnum = StatusEnum.ACTIVE, pageRequest)
            .map {
                FornecedorConverter.toDTO(it)
            }

        return listAllFornecedores
    }

}