package com.altkey.code.context.collection

import com.altkey.code.context.entity.Pagination

/**
 * PaginationList Interface for Kotlin
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
interface PaginationList<T> : MutableList<T> {
    //
    fun setPagination(pagination: Pagination)

    fun getPagination(): Pagination

    fun getMutableList(): MutableList<T>

    fun getList(): List<T>
}