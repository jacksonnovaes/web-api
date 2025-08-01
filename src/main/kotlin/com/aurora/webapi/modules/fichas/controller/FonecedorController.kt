package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.FornecedorRequestDTO
import com.aurora.webapi.modules.fichas.usecases.fornecedores.BuscaPorNomeFornecedores
import com.aurora.webapi.modules.fichas.usecases.fornecedores.ListAllFornecedores
import com.aurora.webapi.modules.fichas.usecases.fornecedores.SaveFornecedor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/fornecedor")
class FonecedorController(
        val listAllFornecedores: ListAllFornecedores,
        val buscaPorNomeFornecedores: BuscaPorNomeFornecedores,
        val saveFornecedor: SaveFornecedor
) {


    @PostMapping("/save")
    fun saveFornecedor(@RequestBody  dto: FornecedorRequestDTO) {
        println("Nome recebido: ${dto.nome}")
        saveFornecedor.execute(dto)
    }
    @GetMapping("/list")
    fun getListAllFichas(): ResponseEntity<List<FornecedorDTO>?> {

        val listAll = listAllFornecedores.execute()

        return ResponseEntity.ok(listAll)
    }

    @GetMapping("/busca")
    fun buscaPorNome(@RequestParam(required = false) nome: String): ResponseEntity<List<FornecedorDTO>> {
        val listAll = buscaPorNomeFornecedores.execute(nome)
        return ResponseEntity.ok(listAll)
    }

}