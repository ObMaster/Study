package org.omaster.springboot_ch01;

import org.junit.jupiter.api.Test;
import org.omaster.springboot_ch01.bean.Dog;
import org.omaster.springboot_ch01.bean.Person;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootCh01ApplicationTests {

    @Resource
    private Dog dog;

    @Resource
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }

}
