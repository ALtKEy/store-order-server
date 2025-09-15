package com.altkey.code.store.order.controller

import com.altkey.code.store.order.entity.Setting
import com.altkey.code.store.order.service.SettingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/settings")
class SettingController(val service: SettingService) {

    @GetMapping("/{id}")
    fun getSetting(@PathVariable("id") id : Long): ResponseEntity<Setting> {
        return ResponseEntity(service.getSetting(id), HttpStatus.OK)
    }

    @PostMapping("/{id}")
    fun setTime(@PathVariable("id") id : Long,
                @RequestBody setting: Setting): ResponseEntity<Setting> {
        println(setting)
        return ResponseEntity(service.saveSetting(setting), HttpStatus.OK)
    }
}