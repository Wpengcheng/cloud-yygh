package com.cheng.cloud.yygh.commom.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;


/**
 * @User Administrator
 * @Classname Swagger2Config
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-11:55
 * @Version 1.0
 */

@Configuration
@EnableSwagger2//开启swagger2
public class Swagger2Config {

    //配置了Swagger2的核心配置docket的bean实例，Docket:swagger的核心配置类
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)//指定api类型为swagger2
                .groupName("webApi")
                .apiInfo(apiInfo())//配置swagger信息
                .enable(true)//是否启动swagger，true启动  false关闭
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)//指定api类型为swagger2
                .groupName("adminApi")
                .apiInfo(apiInfo())//配置swagger信息
                .enable(true)//是否启动swagger，true启动  false关闭
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }



    //配置swagger信息 ApiInfo
    public ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("万里顾一程", "https://mp-new.csdn.net/", "3194525857@qq.com");

        return new ApiInfo("预约挂号的SwaggerAPI文档"
                , "该文档由万里顾一程创作，未经允许，不得转载，后果自负！"
                , "1.0"
                , "https://mp-new.csdn.net/"
                , contact
                , "Apache 2.0"
                , "https://mp-new.csdn.net/"
                , new ArrayList<VendorExtension>());
    }



}
