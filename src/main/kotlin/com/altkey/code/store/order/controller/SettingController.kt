package com.altkey.code.store.order.controller

import com.altkey.code.store.order.entity.Setting
import com.altkey.code.store.order.service.SettingService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.Arguments
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class SettingController(val service: SettingService) {

    @QueryMapping
    fun getSetting(@Argument id : Long): Setting {
        return service.getSetting(id)
    }

    @MutationMapping
    fun updateSetting(@Argument id : Long, @Argument value: String): Setting {
        return service.saveSetting(Setting(id, value))
    }
}