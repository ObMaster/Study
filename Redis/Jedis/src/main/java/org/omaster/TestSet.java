package org.omaster;

import redis.clients.jedis.Jedis;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestSet {

    public static final Jedis jedis = MyRedis.getRedisInstance();

    public static void main(String[] args) {
        jedis.flushDB();

        System.out.println("======向集合中添加成员======");
        System.out.println("添加的成员个数:" + jedis.sadd("setkey", "s1", "s2", "s3", "s4", "s5"));
        System.out.println("集合中的成员个数: " + jedis.scard("setkey"));
        System.out.println("查询Set集合所有成员:" + jedis.smembers("setkey"));
        System.out.println("删除指定的成员: " + jedis.srem("setkey", "s1", "s3"));
        System.out.println("查询Set集合所有成员:" + jedis.smembers("setkey"));
        System.out.println("判断集合中是否存在指定元素s1: " + jedis.sismember("setkey", "s1"));
        System.out.println("判断集合中是否存在指定元素s5: " + jedis.sismember("setkey", "s5"));
        System.out.println("随机移除元素中的成员: " + jedis.spop("setkey"));
        System.out.println("查询Set集合所有成员:" + jedis.smembers("setkey"));

        System.out.println();
        jedis.sadd("sk1", "m1", "m2", "m3", "m4");
        jedis.sadd("sk2", "m2", "m4");
        System.out.println("集合sk1: " + jedis.smembers("sk1"));
        System.out.println("集合sk2: " + jedis.smembers("sk2"));
        System.out.println("将集合sk1中的指定元素m1移动到集合sk2中: " + jedis.smove("sk1", "sk2", "m3"));
        System.out.println("移动后集合sk1: " + jedis.smembers("sk1"));
        System.out.println("移动后集合sk2: " + jedis.smembers("sk2"));

        System.out.println("\n======集合运算======");
        System.out.println("sk1对sk2的差集:" + jedis.sdiff("sk1", "sk2"));
        System.out.println("sk1与sk2的交集:" + jedis.sinter("sk1", "sk2"));
        System.out.println("sk1与sk2的并集:" + jedis.sunion("sk1", "sk2"));
    }
}
