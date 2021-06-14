package org.omaster.springboot_ch01.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties作用：
 *  将配置文件中配置的每一个属性的值，映射到这个组件中；
 *  告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *  参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
 *  使用此注解需导入如下依赖：
 *    <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-configuration-processor</artifactId>
 *      <optional>true</optional>
 *    </dependency>
 *
 * @PropertySource注解的作用：
 *  加载指定的properties配置文件
 *
 * @Validated：
 *  开启JSR303校验
 *
 * @author OMaster
 * @date 2021/6/9
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource("classpath:aa.properties")
//@Validated
public class Person {
    //@Value("${name}")
    //@Email(message = "值不是邮箱类型！")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
