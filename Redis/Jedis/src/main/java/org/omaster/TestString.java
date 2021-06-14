package org.omaster;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.concurrent.TimeUnit;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestString {

    public static Jedis jedis = MyRedis.getRedisInstance();

    public static void main(String[] args) {

        jedis.flushDB();
        System.out.println("======增加数据========");
        System.out.println(jedis.set("k1", "v1"));
        System.out.println(jedis.set("k2", "v2"));
        System.out.println(jedis.set("k3", "v3"));
        System.out.println("删除键k2:" + jedis.del("k2"));
        System.out.println("获取键k2的值: " + jedis.get("k2"));
        System.out.println("修改键k1: " + jedis.set("k1", "redis"));
        System.out.println("获取键k1的值: " + jedis.get("k1"));
        System.out.println("追加k3的值:" + jedis.append("k3", "End"));
        System.out.println("获取k3的值:" + jedis.get("k3"));
        System.out.println("获取多个键值对:" + jedis.mget("k1", "k2", "k3", "k4"));
        System.out.println("删除多个键值对:" + jedis.del("k1", "k4"));
        System.out.println("查询所有的key:" + jedis.keys("*"));

        jedis.flushDB();
        System.out.println(jedis.setnx("k1", "v1"));
        System.out.println(jedis.setnx("k2", "v2"));
        System.out.println("setnx: 不存在则创建,存在不操作——" + jedis.setnx("k2", "v2_new"));
        System.out.println(jedis.mget("k1", "k2"));

        System.out.println("======设置过期时间======");
        System.out.println("对已经存在的key设置过期时间: " + jedis.expire("k2", 10L));
        System.out.println(jedis.get("k2"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("k2"));

        System.out.println("======在设置值的同时设置过期时间的两种方式===========");
        System.out.println("不推荐的方式:setex方法,新版本中可能被set方法取代----" + jedis.setex("k4", 10L, "v4"));
        System.out.println("推荐的方式: 带参数的set方法----" + jedis.set("k5", "v5 time", SetParams.setParams().ex(10L)));

        System.out.println("======先获取已有值,在更新新值======");
        System.out.println("方式一: getset方法,新版本中可能被set方法取代----" + jedis.getSet("k1", "k1 is the first key!"));
        System.out.println("方式二: 带get参数的set方法----" + jedis.set("k1", "second opeartion!", SetParams.setParams().get()));
        System.out.println("获取更新后的k1的值: " + jedis.get("k1"));

        System.out.println("获取k1的子串" + jedis.getrange("k1", 4, 10));


    }
}
