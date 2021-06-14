package org.omaster;

import redis.clients.jedis.Jedis;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestPing {
    public static void main(String[] args) {
        // 1. 连接redis
        Jedis jedis = new Jedis("172.18.232.233", 6379);
        jedis.auth("111111");
        // 2. 测试连接
        String ping = jedis.ping();
        System.out.println(ping);
        //jedis.close();
        jedis.quit();
        // 关闭redis服务,会导致redis-server服务关闭
        //jedis.shutdown();

        System.out.println(jedis.get("test"));

        System.out.println(TestKey.jedis);
        System.out.println(TestString.jedis);
    }
}
