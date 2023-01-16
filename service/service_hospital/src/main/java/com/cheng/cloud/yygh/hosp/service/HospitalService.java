package com.cheng.cloud.yygh.hosp.service;

import com.cheng.cloud.yygh.model.hosp.Hospital;

import java.util.Map;

/**
 * @User Administrator
 * @Classname HospitalService
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:20
 * @Version 1.0
 */
public interface HospitalService {

    void save(Map<String, Object> map);

    Hospital getHospitalByHoscode(String hoscode);
}
