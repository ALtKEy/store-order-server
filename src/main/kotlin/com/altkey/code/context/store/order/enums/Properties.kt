package com.altkey.code.context.store.order.enums

import com.altkey.code.context.enums.PropertiesEnum

enum class Properties (private val key: String) : PropertiesEnum {

    DATABASE_URL("spring.datasource.url")
    ;
    override fun getKey(): String {
       return this.key
    }
}