package com.aurora.webapi.modules.fichas.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface CrudService<T> {

    fun save(entity: T): T

    fun buscarPorId(id: Long): T?

    fun buscarTodos(pageable: Pageable): Page<T>

    fun buscarTodos(): List<T>

    fun buscarPorIds(ids: List<Long>): List<T>

    fun deletar(id: Long)

    fun buscarPorNomeDescricao(termo: String, status: String, pageable: Pageable): Page<T>


}