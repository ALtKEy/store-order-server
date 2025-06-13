package com.altkey.code.store.order.spring

import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class StoreOrderProperties (
    val environment: Environment

) {
    val applicationName: String = environment.getProperty("spring.application.name", "")

}