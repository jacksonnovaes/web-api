package com.aurora.webapi.modules.fichas.usecases.fornecedores

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.converter.FornecedorConverter
import com.aurora.webapi.modules.fichas.infra.repositories.FornecedorRepository
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