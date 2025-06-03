package com.altkey.code.common.database

import java.io.IOException
import java.util.concurrent.ConcurrentHashMap


/**
 * altkey 커넥션 풀
 * Spring Boot 에서 Bean 이 아닌 여럿 커낵선을 관리하기 위함
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-08
 */
abstract class AbstractAltConnectionPool<D : javax.sql.DataSource, C : AutoCloseable?> : AltConnectionPool<C> {
    //
    private val pool: MutableMap<String, D>
    private val dataSource: AltDataSource
    private var isInitialize: Boolean = false

    constructor(dataSource: AltDataSource) {
        this.dataSource = dataSource
        this.pool = ConcurrentHashMap()
    }

    /**
     * <pre>
     * AConnectionPool 초기화
     * 각 Adapter 에서 Pool 에 등록하는 함수
    </pre> *
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    protected abstract fun initialize()

    /**
     * initialize 수행중 pool 등록시 사용한다
     *
     * @param name
     * @param data
     */
    protected fun setPool(name: String, data: D) {
        if (!isInitialize) {
            pool[name] = data
        }
    }

    /**
     * initialize 된 pool 을 가져온다
     *
     * @param poolName
     * @return
     */
    protected fun getPool(poolName: String): D? {
        return pool[poolName]
    }

    /**
     * pool 에 설정된 Key 리턴
     *
     * @return
     */
    protected fun getPoolKey(): Set<String> {
        return pool.keys
    }

    /**
     * ADataSource 를 리턴
     *
     * @return
     */
    protected fun getADataSource(): AltDataSource {
        return this.dataSource
    }
}