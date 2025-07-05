package com.altkey.code.store.order.spring

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment

/**
 * 프로퍼티 모듈별 읽기 순서 정하기
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-28
 */
@Configuration
@PropertySource($$"file:${config.home}${module.name}.properties")
@PropertySource($$"file:${config.home}${module.name}-${spring.profiles.active}.properties")
class StoreOrderPropertiesConfigure(
    val environment: Environment
) {
}