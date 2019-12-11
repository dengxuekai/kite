package com.dxk.kite.rpc.aop;

import com.dxk.kite.utils.result.ResultUtil;
import com.dxk.kite.common.exception.BaseException;
import com.dxk.kite.common.exception.BaseExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Author dengxuekai
 * @Date 2019-12-05 14:41
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class ReturnExceptionAspect {

    @Pointcut("@annotation(com.dxk.kite.rpc.annotation.ReturnExceptionResult)")
    public void returnExceptionResult() {
    }

    @Around(value = "returnExceptionResult()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        try {
            long startTime = System.currentTimeMillis();
            Object obj = joinPoint.proceed();
            long rt = System.currentTimeMillis() - startTime;
            if (rt - startTime > 1000) {
                log.warn("业务接口响应过慢，方法：{},时间：{}ms", className + "." + methodName, rt);
            }
            return obj;
        } catch (ConstraintViolationException cve) {
            Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
            ConstraintViolation<?> cv = constraintViolations.iterator().next();
            log.info("RPC参数异常:{}", cv.getMessage());
            return ResultUtil.genResultWhitError(BaseExceptionCode.PARAM_ERROR.getCode(), cv.getMessage());
        } catch (BaseException be) {
            log.info("RPC业务异常,code:{}, msg:{}", be.getCode(), be.getMessage());
            return ResultUtil.genResultWhitError(be.getCode(), be.getMessage());
        } catch (Throwable throwable) {
            log.error("系统异常:");
            throwable.printStackTrace();
            return ResultUtil.genResultWhitError(BaseExceptionCode.SYSTEM_ERROR);
        }
    }
}
