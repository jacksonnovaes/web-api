package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.usecases.ListAllFornecedores
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/fornecedores")
class FonecedorController(
        val listAllFornecedores: ListAllFornecedores
) {

    @GetMapping("/list")
    fun getListAllFichas() : ResponseEntity<List<FornecedorDTO>?> {

        val listAll = listAllFornecedores.execute()

        return ResponseEntity.ok(listAll)
    }


    @GetMapping("/busca")
    fun buscaPronome() : ResponseEntity<List<FornecedorDTO>?> {

        val listAll = listAllFornecedores.execute()

        return ResponseEntity.ok(listAll)
    }
}