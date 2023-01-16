package com.cheng.cloud.yygh.hosp.service;

import com.cheng.cloud.yygh.model.hosp.Department;
import com.cheng.cloud.yygh.vo.hosp.DepartmentQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @User Administrator
 * @Classname DepartmentService
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-15-13:50
 * @Version 1.0
 */
public interface DepartmentService {
    void save(Map<String, Object> map);

    Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo);

    void remove(String hoscode, String depcode);
}
