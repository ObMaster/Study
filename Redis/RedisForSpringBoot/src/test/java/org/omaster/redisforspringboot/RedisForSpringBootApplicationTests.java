package org.omaster.redisforspringboot;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.omaster.redisforspringboot.bean.User;
import org.omaster.redisforspringboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisForSpringBootApplicationTests {

    //@Autowired
    //@Qualifier("redisTemplate")
    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        /**
         *  opsForValue()   操作String字符串
         *  opsForHash()    操作Hash哈希
         *  opsForList()    操作List列表
         *  opsForSet()     操作Set集合
         *  opsForZSet()    操作ZSet有序集合
         */
        redisTemplate.opsForValue().set("test", "one");
        redisTemplate.opsForValue().set("sk", "中文字符串");
        System.out.println(redisTemplate.opsForValue().get("test"));
        System.out.println(redisTemplate.opsForValue().get("sk"));

        // 获取redis的连接对象
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        System.out.println(redisConnection.keys(new byte[]{'*'}));
        System.out.println(redisTemplate.opsForValue().get("test"));
        redisConnection.flushDb();
        System.out.println(redisTemplate.opsForValue().get("sk"));
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("思特奇", 20);
        System.out.println(JSONObject.toJSONString(user));
        String jsonUser = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(jsonUser);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1() {
        System.out.println(redisTemplate.expire("one", 100, TimeUnit.SECONDS));
        System.out.println(redisTemplate.getExpire("one", TimeUnit.SECONDS));
        System.out.println(redisTemplate.getExpire("user", TimeUnit.SECONDS));
        System.out.println(redisTemplate.getExpire("test"));
        System.out.println(redisTemplate.getExpire("test", TimeUnit.SECONDS));

        System.out.println(redisUtil.set("OMaster", "Lenovo xiaoXin Pro16"));
        System.out.println(redisUtil.get("OMaster"));
    }

}
