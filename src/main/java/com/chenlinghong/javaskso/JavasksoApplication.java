package com.chenlinghong.javaskso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.chenlinghong.javaskso.dao")
public class JavasksoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavasksoApplication.class, args);
    }
}
