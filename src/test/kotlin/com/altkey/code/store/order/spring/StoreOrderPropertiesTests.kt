package com.altkey.code.store.order.spring

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import kotlin.test.assertEquals

@SpringBootTest
@ContextConfiguration(classes= [StoreOrderProperties::class])
class StoreOrderPropertiesTests @Autowired constructor(
    private val storeOrderProperties: StoreOrderProperties
) {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setupProperties() {
            System.setProperty("module.name", "storeorder")
        }
    }

    @Test
    fun contextLoads() {
        assertEquals("store-order", storeOrderProperties.applicationName)
    }
}