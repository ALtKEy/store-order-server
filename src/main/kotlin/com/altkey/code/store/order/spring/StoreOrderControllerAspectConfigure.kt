package com.altkey.code.store.order.spring

import io.github.oshai.kotlinlogging.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.context.annotation.Configuration

/**
 * AspectJ Logging
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-06-22
 */
@Aspect
@Configuration
class StoreOrderControllerAspectConfigure {
    //
    private val logger = KotlinLogging.logger {}

    @Pointcut("execution(* com.altkey.code.*.*.controller..*.*(..))")
    fun controllerMethods() {
    }

        @Before("controllerMethods()")
    fun before(joinPoint: JoinPoint) {
        // MethodSignature로 캐스팅하여 더 상세한 정보에 접근
        val signature = joinPoint.signature as MethodSignature
        val className = signature.declaringType.simpleName
        val methodName = signature.name

        // 파라미터 타입들의 이름을 추출
        val paramTypes = signature.parameterTypes.joinToString { it.simpleName }

        // 파라미터 값들을 추출 (이전과 동일)
        val argValues = joinPoint.args.joinToString {
            it?.toString() ?: "null"
        }

        // "메서드명(파라미터타입)" 형식으로 로그 출력
        logger.info { "START, $className.$methodName($paramTypes) params: [$argValues]" }
    }

    @Around("controllerMethods()")
    @Throws(Throwable::class)
    fun around(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        //
        val start: Long = System.currentTimeMillis()
        try {
            // 대상 메소드 실행
            return proceedingJoinPoint.proceed()
        } finally {
            val executionTime: Long = System.currentTimeMillis() - start
            val signature: MethodSignature = proceedingJoinPoint.signature as MethodSignature
            val className = signature.declaringType.simpleName
            val methodName = signature.name
            val paramTypes = signature.parameterTypes.joinToString { it.simpleName }

            logger.info { "END, $className.$methodName($paramTypes) (${executionTime}ms)" }
        }
    }
}