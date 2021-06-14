package org.omaster;

import redis.clients.jedis.Jedis;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestKey {

    public static Jedis jedis = MyRedis.getRedisInstance();

    public static void main(String[] args) {

        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("判断某个键是否存在：" + jedis.exists("username"));
        System.out.println("新增<key, value>的键值对:" + jedis.set("username", "redis"));
        System.out.println("新增<key, value>的键值对:" + jedis.set("password", "123456"));
        System.out.println("系统中所有的键集合:" + jedis.keys("*"));

        System.out.println("删除键:" + jedis.del("password"));
        System.out.println("判断键是否存在:" + jedis.exists("password"));
        System.out.println("查看键对于值的类型:" + jedis.type("username"));
        System.out.println("随机返回key:" + jedis.randomKey());
        System.out.println("重命名key" + jedis.rename("username", "name"));
        System.out.println("获取key的值:" + jedis.get("name"));
        System.out.println("按索引查询:" + jedis.select(0));
        System.out.println("获取当前数据库中的key的个数: " + jedis.dbSize());
        System.out.println("删除所有数据库中的数据:" + jedis.flushAll());
    }
}
