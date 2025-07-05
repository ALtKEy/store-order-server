package com.altkey.code.store.order.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * 카테고리 (전화, 배달의민족, 네이버 등)
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-01
 */
@Entity
class Category (
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    /**
     * 카테고리 명
     */
    @Column(nullable = false)
    private val value: String,

    /**
     * 생성일
     */
    @CreationTimestamp
    private val createDateTime: LocalDateTime,

    /**
     * 수정일
     */
    @UpdateTimestamp
    private val updateDateTime: LocalDateTime,

    /**
     * 삭제여부
     */
    @Column(nullable = false)
    private val deleted: Boolean = false
) {
}