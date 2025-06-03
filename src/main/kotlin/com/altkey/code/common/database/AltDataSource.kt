package com.altkey.code.common.database

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
interface AltDataSource {
    /**
     * DataSource 를 가져온다
     *
     * @param name
     * @return
     */
    fun getADataSource(name: String?): AltDataSource
}