package com.dxk.kite.redis.service;

import java.util.List;

/**
 * @author hzdengxuekai
 * @date 2018/12/3 17:26
 */
public interface RedisService {

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	boolean set(String key, Object value);

	/**
	 *
	 * @param key
	 * @return
	 */
	Object get(String key);

}
