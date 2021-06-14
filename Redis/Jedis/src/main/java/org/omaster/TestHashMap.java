package org.omaster;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestHashMap {

    private static final Jedis jedis = MyRedis.getRedisInstance();

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("f1", "v1");
        map.put("f2", "v2");
        map.put("f3", "v3");
        map.put("f4", "v4");

        jedis.del("hk", "hk2");
        System.out.println("创建Hash对象hk: " + jedis.hset("hk", map));
        System.out.println("创建Hash对象hk2: " + jedis.hset("hk2", "f5", "v5"));
        System.out.println("创建Hash对象hk2: " + jedis.hset("hk2", "f6", "60"));
        System.out.println("获取hk的所有键值对: " + jedis.hgetAll("hk"));
        System.out.println("获取hk2的所有键值对: " + jedis.hgetAll("hk2"));
        System.out.println("为Hash中的指定键的值加上增量,为负数时为减量,值不为数字则报错:" +
                jedis.hincrBy("hk2", "f6", 100));
        System.out.println("为Hash中的指定键的值加上增量,不存在则默认初始值为0,然后相加:" +
                jedis.hincrBy("hk", "f0", 100));
        System.out.println("获取hk的所有键值对: " + jedis.hgetAll("hk"));
        System.out.println("为Hash中的指定键的值加上增量,为负数时为减量,值不为数字则报错:" +
                jedis.hincrBy("hk", "f0", -50));
        System.out.println("获取hk的所有键值对: " + jedis.hgetAll("hk"));

        System.out.println();

        System.out.println("获取hk中的键值对数量:" + jedis.hlen("hk"));
        System.out.println("判断hk中是否存在指定的键:" + jedis.hexists("hk", "f0"));
        System.out.println("获取hk中指定键的值:" + jedis.hmget("hk", "f1", "f3", "f5"));
        System.out.println("获取hk中所有的键:" + jedis.hkeys("hk"));
        System.out.println("获取hk中所有的值:" + jedis.hvals("hk"));
        System.out.println("删除hk中的指定键:" + jedis.hdel("hk", "f0", "f2"));
        System.out.println("获取hk的所有键值对: " + jedis.hgetAll("hk"));
    }
}
