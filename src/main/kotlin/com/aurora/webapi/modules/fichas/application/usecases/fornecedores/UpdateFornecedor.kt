package com.aurora.webapi.modules.fichas.application.usecases.fornecedores

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.FornecedorRequestDTO
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FornecedorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import org.springframework.stereotype.Service

@Service
class UpdateFornecedor(
     val fornecedorRepository: FornecedorRepository
) {

    fun execute(id: Long, fornecedorDTO: FornecedorRequestDTO ) {
        try{
            val fornecedor = fornecedorRepository.findById(id).orElseThrow {EntityNotFoundException("Fornecedor não Encontrado")}
            fornecedorRepository.save(
                FornecedorEntity(
                    id = id,
                    nome = fornecedorDTO.nome,
                    fichas = fornecedor.fichas
                )
        )
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}