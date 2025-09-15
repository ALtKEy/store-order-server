package com.altkey.code.store.order.service

import com.altkey.code.common.exception.CodeException
import com.altkey.code.common.exception.CommonError
import com.altkey.code.store.order.entity.Setting
import com.altkey.code.store.order.repository.SettingRepository
import org.springframework.stereotype.Service

@Service
class SettingServiceImpl(val settingRepository: SettingRepository): SettingService  {

    override fun getSetting(id: Long): Setting {
        return settingRepository.findById(id).orElseThrow {
            CodeException(CommonError.NOT_FOUND, "Setting id: $id is not found")
        }
    }

    override fun saveSetting(setting: Setting): Setting {
        return settingRepository.save<Setting>(setting)
    }
}