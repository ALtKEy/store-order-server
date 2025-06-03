package com.altkey.code.common.database

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
interface AltConnection<C : AutoCloseable?> {
    /**
     * @return
     */
    fun getConnection(): C?

    /**
     * @param connection
     */
    fun releaseConnection(connection: C?)
}