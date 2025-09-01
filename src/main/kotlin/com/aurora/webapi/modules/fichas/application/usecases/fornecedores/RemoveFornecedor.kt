package com.aurora.webapi.modules.fichas.application.usecases.fornecedores

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.exceptions.EntityNotFoundException
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.FornecedorEntity
import com.aurora.webapi.modules.fichas.adapters.outbound.entities.enum.StatusEnum
import com.aurora.webapi.modules.fichas.service.fornecedor.FornecedorService
import org.springframework.stereotype.Service

@Service
class RemoveFornecedor(
     val fornecedorService: FornecedorService
) {

    fun execute(id: Long) {
        try{
            val fornecedor = fornecedorService.buscarPorId(id)
                ?: throw EntityNotFoundException("Fornecedor não Encontrado")
            fornecedorService.save(
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