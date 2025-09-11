package com.altkey.code.store.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table

/**
 * 카테고리 (전화, 배달의민족, 네이버 등)
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-07-01
 */
@Entity
@Table(indexes = [Index(name = "idx_id_n_deleted", columnList = "id, deleted")])
data class Category(
    //
    override var id: Long? = null,

    @Column(length = 30)
    val value: String? = null,

) : AbstractEntity(id)