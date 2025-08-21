package com.aurora.webapi.modules.fichas.controller

import com.aurora.webapi.modules.fichas.FornecedorDTO
import com.aurora.webapi.modules.fichas.FornecedorRequestDTO
import com.aurora.webapi.modules.fichas.usecases.fornecedores.BuscaPorNomeFornecedores
import com.aurora.webapi.modules.fichas.usecases.fornecedores.ListAllFornecedores
import com.aurora.webapi.modules.fichas.usecases.fornecedores.RemoveFornecedor
import com.aurora.webapi.modules.fichas.usecases.fornecedores.SaveFornecedor
import com.aurora.webapi.modules.fichas.usecases.fornecedores.UpdateFornecedor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/fornecedor")
class FonecedorController(
        val listAllFornecedores: ListAllFornecedores,
        val buscaPorNomeFornecedores: BuscaPorNomeFornecedores,
        val saveFornecedor: SaveFornecedor,
        val updateFornecedor: UpdateFornecedor,
        val removeFornecedor: RemoveFornecedor
) {


    @PostMapping("/save")
    fun saveFornecedor(@RequestBody  dto: FornecedorRequestDTO) {
        println("Nome recebido: ${dto.nome}")
        saveFornecedor.execute(dto)
    }

    @PutMapping("/update/{id}")
    fun updateFornecedor(
        @PathVariable id: Long,
        @RequestBody  dto: FornecedorRequestDTO) {
        println("Nome recebido: ${dto.nome}")
        updateFornecedor.execute(id,dto)
    }

    @DeleteMapping("/remove/{id}")
    fun deleteFornecedor(
        @PathVariable id: Long) {
        removeFornecedor.execute(id)
    }

    @GetMapping("/list")
    fun getListAllFornecedor(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "dt_entrada") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,

    ): ResponseEntity<Page<FornecedorDTO>?> {

        val listAll = listAllFornecedores.execute(page, linesPerPage,orderBy,direction)

        return ResponseEntity.ok(listAll)
    }

    @GetMapping("/search/{nome}")
    fun searchFornecedorByName(
        @PathVariable nome: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "order", defaultValue = "dt_entrada") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,

        ): ResponseEntity<Page<FornecedorDTO>?> {

        val listAll = buscaPorNomeFornecedores.execute(nome,page, linesPerPage,orderBy,direction)

        return ResponseEntity.ok(listAll)
    }

}