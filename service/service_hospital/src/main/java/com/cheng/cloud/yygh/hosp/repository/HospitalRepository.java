package com.cheng.cloud.yygh.hosp.repository;

import com.cheng.cloud.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @User Administrator
 * @Classname HospitalRepository
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:17
 * @Version 1.0
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    //mongodb支持springdata，可以通过方法名实现sql操作
    Hospital getHospitalByHoscode(String hoscode);
}
