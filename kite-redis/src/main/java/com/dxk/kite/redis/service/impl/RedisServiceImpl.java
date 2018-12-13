package com.dxk.kite.redis.service.impl;

import com.dxk.kite.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hzdengxuekai
 * @date 2018/12/3 17:26
 */
@Component
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;


	@Override
	public boolean set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
		return true;
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
