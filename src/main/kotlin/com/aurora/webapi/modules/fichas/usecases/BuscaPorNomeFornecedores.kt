package com.aurora.webapi.modules.fichas.usecases

import com.aurora.webapi.modules.fichas.FichaDTO
import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.converter.FichaConverter
import com.aurora.webapi.modules.fichas.converter.FornecedorConverter
import com.aurora.webapi.modules.fichas.infra.entity.FichaEntity
import com.aurora.webapi.modules.fichas.infra.repositories.FichaRepository
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BuscaPorNomeFornecedores(
    val fornecedorRepository: FornecedorRepository
){
    fun execute(nome: String): List<FornecedorDTO> {
        val listAllFornecedores = fornecedorRepository.findByNome(nome)
            .map {
                FornecedorConverter.toDTO(it)
            }

        return listAllFornecedores
    }

}