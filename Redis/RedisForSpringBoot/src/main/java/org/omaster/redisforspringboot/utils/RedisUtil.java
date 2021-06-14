package org.omaster.redisforspringboot.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author OMaster
 * @date 2021/6/9
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object>  redisTemplate;

    /*********************************************************************
     *                      Common
     *********************************************************************/

    /**
     * 指定缓存失效时间
     * @param key   键
     * @param time  时间，单位：秒
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取指定key的过期时间
     * @param key   key不存在返回-2，无过期时间返回-1
     * @return      剩余过期时间，单位：秒
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public void del(String... key) {
        if (key == null && key.length <= 0) {
            return;
        }
        if(key.length == 1) {
            redisTemplate.delete(key[0]);
        } else {
            //redisTemplate.delete(CollectionUtils.arrayToList(key));
        }
    }

    /*********************************************************************
     *                      String
     *********************************************************************/

    /**
     * 设置值
     * @param key
     * @param obj
     */
    public boolean set(String key, Object obj) {
        try {
            redisTemplate.opsForValue().set(key, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

}
