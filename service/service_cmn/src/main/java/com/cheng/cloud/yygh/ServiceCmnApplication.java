package com.cheng.cloud.yygh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @User Administrator
 * @Classname ServiceCmnApplication
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-06-19:49
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.cheng.cloud")
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class);
    }
}
