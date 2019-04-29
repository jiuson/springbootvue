package com.example.springbootvue.springbootjpa.intercepter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program: springboot-jpa
 * @descripttion: web mvc config
 * @author: jiuson
 * @create: 2019-04-19 16:55:18
 */
@EnableWebMvc
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Value("${excludePathPatterns}")
    private String excludePathPatterns;

    @Bean
    TokenIntercepter getTokenIntercepter(){
        return new TokenIntercepter();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getTokenIntercepter()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
        super.addInterceptors(registry);
    }
}
