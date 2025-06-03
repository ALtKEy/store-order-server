package com.altkey.code.store.order.spring

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

/**
 * 프로퍼티 모듈별 읽기 순서 정하기
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-28
 */
@Configuration
@PropertySource("file:\${module.config}\${module.name}.properties")
@PropertySource("file:\${module.config}\${module.name}-\${spring.profiles.active}.properties")
class StoreOrderPropertiesConfigure {
}