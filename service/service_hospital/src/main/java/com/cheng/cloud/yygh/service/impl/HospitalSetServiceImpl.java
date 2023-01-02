package com.cheng.cloud.yygh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.cloud.yygh.mapper.HospitalSetMapper;
import com.cheng.cloud.yygh.model.hosp.HospitalSetDto;
import com.cheng.cloud.yygh.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @User Administrator
 * @Classname HospitalSetServiceImpl
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:43
 * @Version 1.0
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSetDto> implements HospitalSetService {

    /*
    mybatisplus已经在ServiceImpl中已经注入了mapper，所以直接调用即可
    @Autowired
    protected M baseMapper;
     */

    public HospitalSetDto queryById(Long id){
        return baseMapper.selectById(id);
    }


}
