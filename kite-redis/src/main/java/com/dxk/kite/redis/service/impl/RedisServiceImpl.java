package com.dxk.kite.redis.service.impl;

import com.dxk.kite.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hzdengxuekai
 * @date 2018/12/3 17:26
 */
@Slf4j
@Component
public class RedisServiceImpl implements RedisService {

    private static final String KEY_PREFIX = "COM:DXK:";
    private static final String LOCK_VALUE = "1";

    @Value("${spring.application.name:}")
    private String applicationName;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public <T> boolean set(String key, T value) {
        redisTemplate.opsForValue().set(genCacheKey(key), value);
        return true;
    }

    @Override
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(genCacheKey(key));
    }

    @Override
    public boolean remove(String key) {
        assert StringUtils.isNotBlank(genCacheKey(key));
        return redisTemplate.delete(genCacheKey(key));
    }

    @Override
    public boolean tryLock(String key, long expire) {
        return stringRedisTemplate.opsForValue().setIfAbsent(genCacheKey(key), LOCK_VALUE, expire, TimeUnit.SECONDS);
    }

    @Override
    public boolean unLock(String key) {
        return stringRedisTemplate.delete(genCacheKey(key));
    }


    private String genCacheKey(String key) {
        String appName = StringUtils.isNotBlank(applicationName) ? applicationName + ":" : "";
        return KEY_PREFIX + appName + key;
    }

}
