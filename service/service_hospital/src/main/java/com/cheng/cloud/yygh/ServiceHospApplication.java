package com.cheng.cloud.yygh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @User Administrator
 * @Classname ServiceHospApplication
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:09
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.cheng.cloud")
public class ServiceHospApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class,args);
    }
}
