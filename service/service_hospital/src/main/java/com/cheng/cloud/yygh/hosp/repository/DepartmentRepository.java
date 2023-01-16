package com.cheng.cloud.yygh.hosp.repository;

import com.cheng.cloud.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @User Administrator
 * @Classname DepartmentRepository
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-15-13:49
 * @Version 1.0
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
