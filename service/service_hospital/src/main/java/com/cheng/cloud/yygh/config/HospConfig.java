package com.cheng.cloud.yygh.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @User Administrator
 * @Classname HospConfig
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-11:43
 * @Version 1.0
 */
@Configuration
@MapperScan("com.cheng.cloud.yygh.mapper")
public class HospConfig {
}
