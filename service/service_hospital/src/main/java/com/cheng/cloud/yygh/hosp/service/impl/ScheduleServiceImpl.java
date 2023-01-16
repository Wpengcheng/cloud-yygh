package com.cheng.cloud.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cheng.cloud.yygh.commom.helper.HttpRequestHelper;
import com.cheng.cloud.yygh.hosp.repository.ScheduleRepository;
import com.cheng.cloud.yygh.hosp.service.ScheduleService;
import com.cheng.cloud.yygh.model.hosp.Schedule;
import com.cheng.cloud.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @User Administrator
 * @Classname ScheduleServiceImpl
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-16-10:33
 * @Version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void save(Map<String, Object> map) {
        String string = JSONObject.toJSONString(map);
        Schedule schedule = JSONObject.parseObject(string, Schedule.class);
        String hoscode = schedule.getHoscode();
        String hosScheduleId = schedule.getHosScheduleId();
        Schedule scheduleExist = scheduleRepository.getScheduleByHoscodeAndHosScheduleId(hoscode,hosScheduleId);
        if (scheduleExist!=null){
            scheduleExist.setUpdateTime(new Date());
            scheduleExist.setIsDeleted(0);
            scheduleExist.setStatus(1);
            scheduleRepository.save(scheduleExist);
        }else {
            schedule.setUpdateTime(new Date());
            schedule.setCreateTime(new Date());
            schedule.setIsDeleted(0);
            scheduleExist.setStatus(1);
            scheduleRepository.save(schedule);
        }
    }

    @Override
    public Page<Schedule> findPageSchedule(int page, int limit, ScheduleQueryVo scheduleQueryVo) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleQueryVo,schedule);
        schedule.setIsDeleted(0);
        schedule.setStatus(1);
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);
        Example<Schedule> example = Example.of(schedule, matcher);
        Page<Schedule> schedulePage = scheduleRepository.findAll(example, pageRequest);
        return schedulePage;
    }

    @Override
    public void removeSchedule(String hoscode, String hosScheduleId) {
        Schedule schedule = scheduleRepository.getScheduleByHoscodeAndHosScheduleId(hoscode,hosScheduleId);
        if (schedule!=null){
            scheduleRepository.delete(schedule);
        }
    }
}
