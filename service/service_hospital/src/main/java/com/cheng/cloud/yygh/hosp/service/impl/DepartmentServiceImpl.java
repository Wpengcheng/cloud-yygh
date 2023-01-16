package com.cheng.cloud.yygh.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cheng.cloud.yygh.hosp.repository.DepartmentRepository;
import com.cheng.cloud.yygh.hosp.service.DepartmentService;
import com.cheng.cloud.yygh.model.hosp.Department;
import com.cheng.cloud.yygh.vo.hosp.DepartmentQueryVo;
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
 * @Classname DepartmentServiceImpl
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-15-13:50
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void save(Map<String, Object> map) {

        String departmentString = JSONObject.toJSONString(map);
        Department department = JSONObject.parseObject(departmentString, Department.class);
        String depcode = department.getDepcode();
        String hoscode = department.getHoscode();
        Department department1 = departmentRepository.getDepartmentByHoscodeAndDepcode(hoscode,depcode);
        //修改操作
        if (department1!=null){
//            department.setCreateTime(department1.getCreateTime());
//            department.setUpdateTime(new Date());
//            department.setIsDeleted(0);
//            departmentRepository.delete(department1);
//            departmentRepository.save(department);
            department1.setUpdateTime(new Date());
            department1.setIsDeleted(0);
            departmentRepository.save(department1);
        }else {//添加操作
            department.setCreateTime(new Date());
            department.setUpdateTime(new Date());
            department.setIsDeleted(0);
            departmentRepository.save(department);
        }

        departmentRepository.save(department);
    }

    @Override
    public Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentQueryVo,department);
        department.setIsDeleted(0);
        PageRequest pageRequest = PageRequest.of(page - 1, limit);
        //mongodb查询条件
        ExampleMatcher matching = ExampleMatcher.matching()//改变默认字符串匹配方式：模糊查询
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);//忽略大小写
        //创建查询
        Example<Department> example = Example.of(department, matching);
        Page<Department> departmentPage = departmentRepository.findAll(example, pageRequest);
        return departmentPage;
    }

    @Override
    public void remove(String hoscode, String depcode) {
        Department department = departmentRepository.getDepartmentByHoscodeAndDepcode(hoscode, depcode);
        if (department!=null){
            departmentRepository.delete(department);
        }
    }
}
