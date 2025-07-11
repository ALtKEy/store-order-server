package com.altkey.code.context.response

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime

class CategoryResponse (
    //
    var id: Long?,

    /**
     * 카테고리 명
     */
    var value: String,

    /**
     * 생성일
     */
    var createDateTime: LocalDateTime,

    /**
     * 수정일
     */
    var updateDateTime: LocalDateTime,

    /**
     * 삭제여부
     */
    var deleted: Boolean = false
) {
}