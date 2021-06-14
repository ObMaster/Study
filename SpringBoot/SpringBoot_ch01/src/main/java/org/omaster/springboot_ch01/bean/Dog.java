package org.omaster.springboot_ch01.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author OMaster
 * @date 2021/6/9
 */
@Data
@Component
public class Dog {
    @Value("小花")
    private String name;

    @Value("10")
    private int age;

    @Value("${dog.address}")
    private String address;

    @Value(("${dog.test1}"))
    private String testOne;

    @Value(("${dog.test2}"))
    private String testTwo;
}
