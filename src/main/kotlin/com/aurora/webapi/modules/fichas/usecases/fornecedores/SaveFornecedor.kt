package com.aurora.webapi.modules.fichas.usecases.fornecedores

import com.aurora.webapi.exceptions.DataIntegrityException
import com.aurora.webapi.modules.fichas.FornecedorRequestDTO
import com.aurora.webapi.modules.fichas.infra.entity.FornecedorEntity
import com.aurora.webapi.modules.fichas.service.fornecedor.FornecedorService
import org.springframework.stereotype.Service

@Service
class SaveFornecedor(
     val fornecedorService: FornecedorService
) {

    fun execute(fornecedorDTO: FornecedorRequestDTO ) {
        try{
        fornecedorService.save(
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