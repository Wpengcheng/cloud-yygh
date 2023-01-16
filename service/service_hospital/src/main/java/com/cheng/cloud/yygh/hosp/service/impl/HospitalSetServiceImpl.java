package com.cheng.cloud.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.cloud.yygh.hosp.mapper.HospitalSetMapper;
import com.cheng.cloud.yygh.model.hosp.HospitalSetDto;
import com.cheng.cloud.yygh.hosp.service.HospitalSetService;
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

    @Override
    public String getSingKeyByHoscode(String hoscode) {
        QueryWrapper<HospitalSetDto> wrapper = new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSetDto hospitalSetDto = baseMapper.selectOne(wrapper);
        return hospitalSetDto.getSignKey();
    }
}
