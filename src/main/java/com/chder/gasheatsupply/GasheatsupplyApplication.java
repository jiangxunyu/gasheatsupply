package com.chder.gasheatsupply;

import com.chder.gasheatsupply.utils.SpringContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.chder.gasheatsupply.mapper")
@EnableTransactionManagement
@EnableCaching
public class GasheatsupplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GasheatsupplyApplication.class, args);
    }

    @PostConstruct
    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
