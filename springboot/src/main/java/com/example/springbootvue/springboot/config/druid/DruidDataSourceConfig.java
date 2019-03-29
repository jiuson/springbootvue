package com.example.springbootvue.springboot.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @program: springboot-vue
 * @descripttion: Druid的DataSource配置类
 * @author: jiuson
 * @create: 2019-03-27 17:51:26
 */
@Slf4j
@Configuration
public class DruidDataSourceConfig {

    @Autowired
    private Environment environment;

    /**
     * 创建一个druid的DruidDataSource，返回并告诉SpringBoot这是一个Bean
     * @return
     */
    @Bean
    public DataSource dataSource(){
        log.info("注入druid---");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setInitialSize(Integer.valueOf(environment.getProperty("spring.datasource.druid.initial-size")));
        druidDataSource.setMinIdle(Integer.valueOf(environment.getProperty("spring.datasource.druid.min-idle")));
        druidDataSource.setMaxWait(Long.valueOf(environment.getProperty("spring.datasource.druid.max-wait")));
        druidDataSource.setMaxWait(Integer.valueOf(environment.getProperty("spring.datasource.druid.max-active")));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.valueOf(environment.getProperty("spring.datasource.druid.min-evictable-idle-time-millis")));
        try {
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
