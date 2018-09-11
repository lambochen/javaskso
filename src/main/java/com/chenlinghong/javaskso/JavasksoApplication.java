package com.chenlinghong.javaskso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.chenlinghong.javaskso.dao")
public class JavasksoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavasksoApplication.class, args);
    }

    /**
     * 打ｗａｒ包，需要继承类SpringBootServletInitializer，重写configure方法
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return super.configure(builder);
        return builder.sources(JavasksoApplication.class);
    }
}
