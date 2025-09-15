package com.altkey.code.store.order.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-09-09
 */
@MappedSuperclass
abstract class AbstractEntity(
    //
    @Id
    val id: Long? = null,

    @CreationTimestamp
    @Column(updatable = false)
    val createDateTime: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column
    val updateDateTime: LocalDateTime? = null,

    @Column(nullable = false)
    val deleted: Boolean = false
)