package com.altkey.code.store.order.spring

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-05
 */
@Configuration
@EntityScan(basePackages = ["com.altkey.code.store.order.entity"])
@EnableJpaRepositories(basePackages = ["com.altkey.code.store.order.repository"])
@EnableJpaAuditing
@EnableTransactionManagement
class StoreOrderJpaConfigure {
}