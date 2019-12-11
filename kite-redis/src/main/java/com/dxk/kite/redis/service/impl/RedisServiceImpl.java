package com.dxk.kite.redis.service.impl;

import com.dxk.kite.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hzdengxuekai
 * @date 2018/12/3 17:26
 */
@Slf4j
@Component
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public <T> boolean set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    @Override
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean remove(String key) {
        assert StringUtils.isNotBlank(key);
        return redisTemplate.delete(key);
    }

    @Override
    public boolean lock(String key, long expire) {
//        stringRedisTemplate.execute(new RedisCallback<Boolean>() {
//            @Override
//            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                RedisProperties.Jedis jedis = (RedisProperties.Jedis) redisConnection.getNativeConnection();
//                jedis.s
//                return null;
//            }
//        })
        return false;
    }

    @Override
    public boolean unLock(String key) {
        return false;
    }



}
