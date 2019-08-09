package com.wit.sb.studysb.web.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ctw
 * @Project： study-sb
 * @Package: com.wit.sb.studysb.web.web
 * @Description:
 * @date 2019/8/9 9:52
 */
@RestController
public class HelloController {

    @Value("${EnvironmentPostProcessor:}")
    String environmentPostProcessor;

    @Value("${propertySourceLoader:}")
    String propertySourceLoader;

    @GetMapping("hello")
    String hello() {
        return environmentPostProcessor + ":" + propertySourceLoader;
    }
}
