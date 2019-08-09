package com.wit.sb.studysb.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ctw
 * @Project： study-sb
 * @Package: com.wit.sb.studysb.web.config
 * @Description: 在META-INF/spring.factories文件添加：
 * org.springframework.boot.env.EnvironmentPostProcessor=com.wit.sb.studysb.web.config.HelloPropertySourceLoader
 * @date 2019/8/9 9:54
 */
public class HelloEnvironmentPostProcessor implements EnvironmentPostProcessor {


    /**
     * 属性文件路径
     */
    public static final String EXTENSION_FILE_PATH = "C:\\Users\\Administrator\\Desktop\\hello.properties";

    /**
     * 可以加载任意来源的属性
     * @param environment
     * @param application
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("EnvironmentPostProcessor postProcessEnvironment。。。");
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(EXTENSION_FILE_PATH));
            //环境名称随意取，但尽量不能和其他环境名称相同，避免不生效
            PropertiesPropertySource propertySource = new PropertiesPropertySource("environmentPostProcessor", properties);
            environment.getPropertySources().addLast(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
