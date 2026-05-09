package com.aurora.webapi.modules.fichas.application.usecases.fornecedores

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FornecedorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.adapters.outbound.repositories.FornecedorRepository
import org.springframework.stereotype.Service

@Service
class RemoveFornecedor(
     val fornecedorRepository: FornecedorRepository
) {

    fun execute(id: Long) {
        try{
            val fornecedor = fornecedorRepository.findById(id).orElseThrow {
                throw EntityNotFoundException("Fornecedor não Encontrado")
            }
            fornecedorRepository.save(
                FornecedorEntity(
                    id = id,
                    nome = fornecedor.nome,
                    fichas = fornecedor.fichas,
                    status = StatusEnum.INACTIVE
                )
        )
        }catch (e: DataIntegrityException){
            throw DataIntegrityException("campos obrigatorios n'ao informados", e.cause)
        }
    }
}