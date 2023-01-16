package com.cheng.cloud.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cheng.cloud.yygh.hosp.repository.HospitalRepository;
import com.cheng.cloud.yygh.hosp.service.HospitalService;
import com.cheng.cloud.yygh.model.hosp.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @User Administrator
 * @Classname HospitalServiceImpl
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:20
 * @Version 1.0
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    /**
     *
     * @param map 封装Hospital实体类属性的map集合
     */
    @Override
    public void save(Map<String, Object> map) {
        String string = JSONObject.toJSONString(map);
        Hospital hospital = JSONObject.parseObject(string, Hospital.class);
        String hoscode = hospital.getHoscode();
        Hospital hospital1 = hospitalRepository.getHospitalByHoscode(hoscode);
        if (hospital1 !=null){//当对象存在时就修改
            hospital.setStatus(hospital1.getStatus());
            hospital.setCreateTime(hospital1.getCreateTime());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }else {//当对象不存在时就添加
            hospital.setStatus(0);
            hospital.setCreateTime(new Date());
            hospital.setUpdateTime(new Date());
            hospital.setIsDeleted(0);
            hospitalRepository.save(hospital);
        }
        hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getHospitalByHoscode(String hoscode) {
        Hospital hospital = hospitalRepository.getHospitalByHoscode(hoscode);
        return hospital;
    }
}
