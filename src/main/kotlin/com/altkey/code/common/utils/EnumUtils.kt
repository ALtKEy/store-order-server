package com.altkey.code.common.utils

import com.altkey.code.context.enums.CodeEnum
import com.altkey.code.context.enums.PropertiesEnum
import java.util.*
import java.util.function.Supplier

/**
 * Enum Utils
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-06-27
 */
object EnumUtils {
    //
    fun <E> codeEnum(enumClass: Class<E>, value: Any): E where E : Enum<E>, E : CodeEnum {
        try {
            return Arrays.stream<E>(enumClass.getEnumConstants())
                .filter { type: E -> type.getCode() == value }
                .findFirst()
                .orElseThrow<IllegalArgumentException?>(Supplier { IllegalArgumentException("Unknown Enum $value") })
        } catch (e: Exception) {
            throw IllegalArgumentException("Unknown Enum $value")
        }
    }
    fun <E> propertiesEnum(enumClass: Class<E>, value: Any): E where E : Enum<E>, E : PropertiesEnum {
        try {
            return Arrays.stream<E>(enumClass.getEnumConstants())
                .filter { type: E -> type.getKey() == value }
                .findFirst()
                .orElseThrow<IllegalArgumentException?>(Supplier { IllegalArgumentException("Unknown Enum $value") })
        } catch (e: Exception) {
            throw IllegalArgumentException("Unknown Enum $value")
        }
    }
}