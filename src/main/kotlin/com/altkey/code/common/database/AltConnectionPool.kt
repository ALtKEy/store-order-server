package com.altkey.code.common.database

import java.sql.SQLException

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
interface AltConnectionPool<C : AutoCloseable?> {
    //
    /**
     * 제네릭 타입의 커넥션을 리턴
     *
     * @param poolName
     * @return
     * @throws ConnectException
     */
    @Throws(SQLException::class)
    fun getConnectionPool(poolName: String): AltConnection<C?>

    /**
     * 커넥션을 닫는다
     *
     * @param connection
     * @throws ConnectException
     */
    @Throws(SQLException::class)
    fun closeConnectionPool(connection: AltConnection<C?>)
}