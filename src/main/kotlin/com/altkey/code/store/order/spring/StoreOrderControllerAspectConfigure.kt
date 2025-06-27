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
import java.lang.reflect.Method

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

    @Pointcut("execution(* com.altkey.*.controller..*.*(..))")
    fun controllerMethods() {
    }

    @Before("controllerMethods()")
    fun before(joinPoint: JoinPoint) {
        logger.info { "START, ${joinPoint.signature}" }
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
            val method: Method = signature.method
            logger.info { "END, ${proceedingJoinPoint.signature} (${executionTime}ms)" }
        }
    }
}