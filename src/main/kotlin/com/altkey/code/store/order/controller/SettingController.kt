package com.altkey.code.store.order.controller

import com.altkey.code.store.order.entity.Setting
import com.altkey.code.store.order.service.SettingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/setting")
class SettingController(private val service: SettingService) {

    @GetMapping("/{id}")
    fun getSetting(@PathVariable id : Long): Setting {
        return service.getSetting(id)
    }

    @PutMapping("/{id}")
    fun updateSetting(@PathVariable id : Long, @RequestBody setting: Setting): Setting {
        return service.saveSetting(Setting(id, setting.value))
    }
}