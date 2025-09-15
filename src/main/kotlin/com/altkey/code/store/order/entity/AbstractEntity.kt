package com.altkey.code.store.order.entity

import com.altkey.code.store.order.spring.StoreDataSerializationConfigure
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import jakarta.persistence.*
import kotlinx.serialization.Serializable
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

    @Serializable(with = StoreDataSerializationConfigure::class)
    @CreationTimestamp
    @Column(updatable = false)
    val createDateTime: LocalDateTime = LocalDateTime.now(),

    @Serializable(with = StoreDataSerializationConfigure::class)
    @UpdateTimestamp
    @Column
    val updateDateTime: LocalDateTime? = null,

    @Column(nullable = false)
    val deleted: Boolean = false
)