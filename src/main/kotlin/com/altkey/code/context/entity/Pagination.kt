package com.altkey.code.context.entity

import kotlin.math.ceil

/**
 * Pagination for Kotlin
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
class Pagination (
    /**
     * 현재 페이지 번호
     */
    private var currentPage: Int = 0,

    /**
     * 페이지 표시 아이템 개수
     */
    private var pageItemSize: Int = 0
) {
    /**
     * 총 페이지 번호
     */
    private var totalPage: Int = 0

    /**
     * 아이템 전체 개수
     */
    private var totalItem: Long = 0

    /**
     * 서비스단 초기화
     *
     * @param totalItem 아이템 전체 개수
     */
    fun initalize(totalItem: Long) {
        this.totalItem = totalItem
        if (totalItem > pageItemSize) {
            // 페이지에 출력할 아이템 개수가 모자를 경우 페이지 번호를 올림하여 계산
            this.totalPage = ceil(totalItem * 1.0 / pageItemSize).toInt()
        } else {
            this.totalPage = 1
        }
    }

    /**
     * <pre>
     * 최초 시작 숫자
     * 1페이지에 10단위라면 return 0, 2페이지에 10개 단위라면 return 10
     * </pre>
     *
     * @return 페이지 번호에 따른 최초 숫자
     */
    fun getOffset(): Int {
        return if (this.currentPage > 1) {
            (this.currentPage - 1) * this.pageItemSize
        } else {
            0
        }
    }
}