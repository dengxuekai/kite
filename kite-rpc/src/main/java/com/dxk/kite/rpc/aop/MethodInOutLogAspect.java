package com.dxk.kite.rpc.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author dengxuekai
 * @Date 2019-12-11 15:41
 */
@Slf4j
@Aspect
@Order(2)
@Component
public class MethodInOutLogAspect {

    @Pointcut("@annotation(com.dxk.kite.rpc.annotation.MethodInOutLog)")
    public void methodInOutLog() {
    }

    @Around(value = "methodInOutLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        log.info("{}入参:{}", method, JSONObject.toJSONString(joinPoint.getArgs()));
        Object obj = joinPoint.proceed();
        log.info("{}出参:{}", method, JSONObject.toJSONString(obj));
        return obj;
    }
}
