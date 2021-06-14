package org.omaster.springboot_ch01.controller;

import org.omaster.springboot_ch01.bean.Dog;
import org.omaster.springboot_ch01.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author OMaster
 * @date 2021/6/10
 */
@RestController
public class Ch01Controller {

    @Resource
    private Dog dog;

    @Resource
    private Person person;

    @GetMapping("/getDog")
    public Dog getDog() {
        return this.dog;
    }

    @GetMapping("/getPerson")
    public Person getPerson() {
        return this.person;
    }
}
