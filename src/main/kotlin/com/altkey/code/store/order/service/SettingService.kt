package com.altkey.code.store.order.service

import com.altkey.code.store.order.entity.Setting
import java.util.Optional

interface SettingService {

    fun getSetting(id: Long): Setting

    fun saveSetting(setting: Setting): Setting
}