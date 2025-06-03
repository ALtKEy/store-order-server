package com.altkey.code.store.order.repository

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
interface CommonCrudRepository<T> {
    //
    fun <T> insert(value: T): T

    fun <T> update(value: T): T

    fun <T> delete(value: T): T

    fun <T> findById(id: String): T?

    fun <T> findAll(): List<T>?
}