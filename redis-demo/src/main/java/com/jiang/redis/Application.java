package com.jiang.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/7
 */
@SpringBootApplication
@MapperScan("com.jiang.redis.mapper")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
