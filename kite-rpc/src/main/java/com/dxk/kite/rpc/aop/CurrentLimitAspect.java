package com.dxk.kite.rpc.aop;

import com.dxk.kite.utils.result.ResultUtil;
import com.dxk.kite.common.exception.BaseExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

/**
 * @Author dengxuekai
 * @Date 2019-12-05 14:41
 */
@Slf4j
@Aspect
@Order(0)
@Component
public class CurrentLimitAspect {

    @Value("${current.limit.number:500}")
    private Integer currentLimitNumber;

    private Semaphore semaphore;

    private Semaphore getSemaphore() {
        if (this.semaphore == null) {
            semaphore = new Semaphore(currentLimitNumber);
        }
        return semaphore;
    }

    @Pointcut("@annotation(com.dxk.kite.rpc.annotation.CurrentLimit)")
    public void currentLimit() {
    }

    @Around(value = "currentLimit()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Semaphore current = getSemaphore();
        if (current.tryAcquire()) {
            try {
                return joinPoint.proceed();
            } finally {
                current.release();
            }
        } else {
            String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            log.warn("超过系统并发限流上限{}, 方法:{}", currentLimitNumber, method);
            return ResultUtil.genResultWhitError(BaseExceptionCode.OVER_CURRENT_LIMIT);
        }
    }

}
