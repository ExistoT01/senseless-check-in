package org.ouc.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.ouc.management"})
@MapperScan(basePackages = {"org.ouc.management.mapper"})
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
