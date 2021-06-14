package org.omaster;

import redis.clients.jedis.Jedis;

/**
 * @author OMaster
 * @date 2021/6/8
 */
public class TestList {
    /**
     *  List 可以理解为一个队列,左侧第一个元素为0,右侧第一个元素为-1
     *      lpush 从左侧入队,先入队的索引较大
     *      rpush 从右侧入队,先入队的索引较小
     */
    public static void main(String[] args) {
        Jedis jedis = MyRedis.getRedisInstance();

        jedis.flushDB();
        System.out.println("======添加一个List======");
        System.out.println("添加一个List对象:" + jedis.lpush("collections", "ArrayList", "Stack", "HashMap"));
        System.out.println("获取所有元素(0:第一个元素, -1:最后一个元素):" + jedis.lrange("collections", 0, -1));
        System.out.println("从列表头/首部(左侧)添加元素: " + jedis.lpush("collections", "left"));
        System.out.println("从列表尾部(右侧)添加元素: " + jedis.rpush("collections", "right"));
        System.out.println("获取列表所有元素:" + jedis.lrange("collections", 0, -1));
        System.out.println("查询指定区间[1, 3]的元素:" + jedis.lrange("collections", 1, 3));
        System.out.println("弹出列表左侧元素: " + jedis.lpop("collections"));
        System.out.println("弹出列表右侧元素: " + jedis.rpop("collections"));

        System.out.println();
        System.out.println("删除指定元素的个数: " + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("获取列表所有元素:" + jedis.lrange("collections", 0, -1));
        System.out.println("补充列表数据: " + jedis.lpush("collections","three", "two", "one", "zero"));
        System.out.println("获取所有List元素:" + jedis.lrange("collections", 0, -1));
        System.out.println("截取指定[1, -2]区间的元素(1表示第二个元素,-2表示倒数第二个元素):" +
                jedis.ltrim("collections", 1, -2));
        System.out.println("获取列表所有元素:" + jedis.lrange("collections", 0, -1));

        System.out.println();
        System.out.println("获取指定索引下标的值: " + jedis.lindex("collections", -1));
        System.out.println("修改指定索引的值:" + jedis.lset("collections", -1, "end"));
        System.out.println("获取列表所有元素:" + jedis.lrange("collections", 0, -1));
        System.out.println("获取列表中元素个数(长度):" + jedis.llen("collections"));

        System.out.println("======排序操作======");
        jedis.lpush("lk","4", "7", "9", "5", "1", "6");
        System.out.println("排序前: " + jedis.lrange("lk", 0, -1));
        System.out.println("排序操作: " + jedis.sort("lk"));
    }
}
