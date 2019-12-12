package com.dxk.kite.redis.service;

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
    <T> boolean set(String key, T value);

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    <T> T get(String key);

    /**
     * 删除缓存
     *
     * @param key
     * @return
     */
    boolean remove(String key);

    /**
     * 加分布式锁
     *
     * @param key
     * @param expire
     * @return
     */
    boolean tryLock(String key, long expire);

    /**
     * 释放分布式锁
     *
     * @param key
     * @return
     */
    boolean unLock(String key);

}
