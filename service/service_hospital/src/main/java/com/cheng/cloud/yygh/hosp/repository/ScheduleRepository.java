package com.cheng.cloud.yygh.hosp.repository;

import com.cheng.cloud.yygh.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @User Administrator
 * @Classname ScheduleRepository
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-16-10:32
 * @Version 1.0
 */
@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);
}
