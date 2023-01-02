package com.cheng.cloud.yygh.controller;

import com.cheng.cloud.yygh.service.HospitalSetService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @User Administrator
 * @Classname HospitalSetController
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:51
 * @Version 1.0
 */
//以Json字符串的形式返回给客户端
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {


    @Autowired
    private HospitalSetService hospitalSetService;



}
