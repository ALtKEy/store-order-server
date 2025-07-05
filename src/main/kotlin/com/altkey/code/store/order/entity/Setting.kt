package com.altkey.code.store.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(nullable = false)
    private val value: String,

    @Column(nullable = false)
    private val deleted: Boolean = false,
) {
}