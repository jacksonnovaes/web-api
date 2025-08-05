package com.aurora.webapi.modules.fichas.service


interface CrudService<T> {

    fun save(entity: T): T

    fun buscarPorId(id: Long): T?

    fun buscarTodos(): List<T>

    fun buscarPorIds(ids: List<Long>): List<T>

    fun deletar(id: Long)
}