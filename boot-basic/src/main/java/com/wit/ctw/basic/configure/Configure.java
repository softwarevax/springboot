package com.wit.ctw.basic.configure;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author twcao
 * @description bean配置
 * @project boot-basic
 * @classname Configure
 * @date 2019/11/25 11:31
 */
public class Configure {

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean beanFilter = new FilterRegistrationBean();
        beanFilter.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        beanFilter.setInitParameters(initParams);
        beanFilter.setUrlPatterns(Arrays.asList("/*"));
        return  beanFilter;
    }

    @Bean
    public ServletRegistrationBean setStatViewServlet(){
        ServletRegistrationBean beanServlet = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","root");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认允许任何访问但需提供账户和密码
        beanServlet.setInitParameters(initParams);
        return  beanServlet;

    }

}
