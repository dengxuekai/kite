package com.dxk.kite.rpc.aop;

import com.alibaba.fastjson.JSONObject;
import com.dxk.kite.common.exception.BaseException;
import com.dxk.kite.common.exception.BaseExceptionCode;
import com.dxk.kite.redis.service.RedisService;
import com.dxk.kite.rpc.annotation.DistributedJob;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DistributedJobAspect {

    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.dxk.kite.rpc.annotation.DistributedJob)")
    public void distributedJob() {
    }

    @Around(value = "distributedJob()&&@annotation(distributedJobA)")
    public boolean around(ProceedingJoinPoint joinPoint, DistributedJob distributedJobA) throws Throwable {
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()";
        long expireSecond = distributedJobA.expireSeconds();
        if (redisService.tryLock(method, expireSecond)) {
            try {
                log.info("本服务器开始执行定时任务:{}", method);
                Object obj = joinPoint.proceed();
                if (!(obj instanceof Boolean)) {
                    throw new BaseException(BaseExceptionCode.JOB_MUST_RETURN_BOOLEAN);
                }
                log.info("本服务器完成执行定时任务:{}", method);
                return (Boolean) obj;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                redisService.unLock(method);
            }
        } else {
            log.info("其他服务器完成执行定时任务:{}", method);
            return true;
        }
    }
}
