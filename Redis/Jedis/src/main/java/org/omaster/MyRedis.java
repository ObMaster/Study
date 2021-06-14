package org.omaster;

import redis.clients.jedis.Jedis;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class MyRedis {

    private static Jedis jedis;

    private MyRedis() {
    }

    /**
     * 单例模式: 获取Redis连接对象
     * @return
     */
    public static Jedis getRedisInstance() {
        if (jedis == null) {
            jedis = new Jedis("172.18.232.233", 6379);
            jedis.auth("111111");
        }
        return jedis;
    }

    public static void main(String[] args) {
        String a = "a", b = "b", c = a + b, d = new String("a + b");
        System.out.println(a + b == c);

        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);

        System.out.println(i01 == i02);
        System.out.println(i01 == i03);
        System.out.println(i03 == i04);
        System.out.println(i02 == i04);
    }
}
