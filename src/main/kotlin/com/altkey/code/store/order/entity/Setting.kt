package com.altkey.code.store.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

/**
 * 번호표 설정
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-05
 */
@Entity
@Table(name = "settings")
class Setting(

    override val id: Long? = null,

    @Column(length = 100, nullable = false)
    val value: String,

) : AbstractEntity(id) {
}