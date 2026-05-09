package com.aurora.webapi.modules.fichas.application.usecases.fornecedores

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FornecedorRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FornecedorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import org.springframework.stereotype.Service

@Service
class SaveFornecedor(
     val fornecedorRepository: FornecedorRepository
) {

    fun execute(fornecedorDTO: FornecedorRequestDTO ) {
        try{
            fornecedorRepository.save(
            FornecedorEntity(
                id = null,
                nome = fornecedorDTO.nome,
                fichas = emptyList()
            )
        )
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}