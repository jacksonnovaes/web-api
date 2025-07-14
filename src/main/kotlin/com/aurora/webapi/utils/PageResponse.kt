package com.aurora.webapi.utils

import org.springframework.data.domain.Page

data class PageResponse<T> (
    val content: List<T>,
    val pageNumber: Int,
    val pageSize: Int,
    val totalElements: Long,
    val totalPages: Int,
    val isLast: Boolean
) {

}