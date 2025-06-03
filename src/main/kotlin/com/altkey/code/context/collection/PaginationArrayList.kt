package com.altkey.code.context.collection

import com.altkey.code.context.entity.Pagination

/**
 * Pagination ArrayList for Kotlin
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
class PaginationArrayList<E> : ArrayList<E>, MutableList<E>, PaginationList<E> {
    //
    private lateinit var pagination: Pagination

    constructor() : super()

    constructor(c: Collection<E>) : super(c)

    constructor(c: Collection<E>, pagination: Pagination) : super(c) {
        this.pagination = pagination
    }

    constructor(initialCapacity: Int) : super(initialCapacity)

    override fun setPagination(pagination: Pagination) {
        this.pagination = pagination
    }

    override fun getPagination(): Pagination {
        return this.pagination
    }

    override fun getMutableList(): MutableList<E> {
        return this.toMutableList()
    }

    override fun getList(): List<E> {
        return this.toList()
    }
}