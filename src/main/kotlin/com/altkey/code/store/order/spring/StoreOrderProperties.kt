package com.altkey.code.store.order.spring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class StoreOrderProperties (
    private val environment: Environment

) {
    val applicationName: String = environment.getProperty("spring.application.name", "")

}