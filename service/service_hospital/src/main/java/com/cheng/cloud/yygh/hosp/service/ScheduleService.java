package com.cheng.cloud.yygh.hosp.service;

import com.cheng.cloud.yygh.model.hosp.Schedule;
import com.cheng.cloud.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @User Administrator
 * @Classname ScheduleService
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-16-10:33
 * @Version 1.0
 */
public interface ScheduleService {

    void save(Map<String, Object> map);

    Page<Schedule> findPageSchedule(int page, int limit, ScheduleQueryVo scheduleQueryVo);


    void removeSchedule(String hoscode, String hosScheduleId);
}
