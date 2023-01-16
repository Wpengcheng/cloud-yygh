package com.cheng.cloud.yygh.hosp.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.cheng.cloud.yygh.commom.helper.HttpRequestHelper;
import com.cheng.cloud.yygh.commom.utils.MD5;
import com.cheng.cloud.yygh.commom.utils.SignUtil;
import com.cheng.cloud.yygh.common.exception.YyghException;
import com.cheng.cloud.yygh.common.result.Result;
import com.cheng.cloud.yygh.common.result.ResultCodeEnum;
import com.cheng.cloud.yygh.hosp.service.DepartmentService;
import com.cheng.cloud.yygh.hosp.service.HospitalService;
import com.cheng.cloud.yygh.hosp.service.HospitalSetService;
import com.cheng.cloud.yygh.hosp.service.ScheduleService;
import com.cheng.cloud.yygh.model.hosp.Department;
import com.cheng.cloud.yygh.model.hosp.Hospital;
import com.cheng.cloud.yygh.model.hosp.Schedule;
import com.cheng.cloud.yygh.vo.hosp.DepartmentQueryVo;
import com.cheng.cloud.yygh.vo.hosp.ScheduleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @User Administrator
 * @Classname ApiController
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/hosp/")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    //添加医院信息
    @PostMapping("saveHospital")
    public Result saveHospital(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        SignUtil.checkSign(map,singKey);
        String logoData = (String) map.get("logoData");
        if (!StringUtils.isEmpty(logoData)){
            logoData = logoData.replaceAll(" ", "+");
            map.put("logoData",logoData);
        }
        hospitalService.save(map);
        return Result.ok();
    }

    //查询医院信息
    @PostMapping("hospital/show")
    public Result getHospital(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        Hospital hospital = hospitalService.getHospitalByHoscode(hoscode);
        return Result.ok(hospital);
    }

    //添加科室信息
    @PostMapping("saveDepartment")
    public Result saveDepartment(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        //判断签名是否一致
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        SignUtil.checkSign(map,singKey);
        departmentService.save(map);
        return Result.ok();
    }

    //查询科室信息
    @PostMapping("/department/list")
    public Result findDepartment(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        int page = StringUtils.isEmpty(map.get("page")) ? 1 : Integer.parseInt((String)map.get("page"));
        int limit = StringUtils.isEmpty(map.get("limit")) ? 1 : Integer.parseInt((String)map.get("limit"));
        DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
//        departmentQueryVo.setHoscode(hoscode);
        Page<Department> department = departmentService.findPageDepartment(page,limit,departmentQueryVo);
        return Result.ok(department);
    }

    //删除科室信息
    @PostMapping("department/remove")
    public Result removeDepartment(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String depcode = (String) map.get("depcode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        departmentService.remove(hoscode,depcode);
        return Result.ok();
    }



    //添加排班信息
    @PostMapping("saveSchedule")
    public Result saveSchedule(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        scheduleService.save(map);
        return Result.ok();
    }
    //查询排班信息
    @PostMapping("schedule/list")
    public Result findSchedule(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        int page = StringUtils.isEmpty(map.get("page")) ? 1 : Integer.parseInt((String) map.get("page"));
        int limit = StringUtils.isEmpty(map.get("limit")) ? 1 : Integer.parseInt((String) map.get("limit"));
        ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
        Page<Schedule> schedulePage = scheduleService.findPageSchedule(page,limit,scheduleQueryVo);
        return Result.ok(schedulePage);
    }

    //删除科室信息
    @PostMapping("schedule/remove")
    public Result removeSchedule(HttpServletRequest httpServletRequest){
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> map = HttpRequestHelper.switchMap(parameterMap);
        String hoscode = (String) map.get("hoscode");
        String singKey = hospitalSetService.getSingKeyByHoscode(hoscode);
        //判断签名是否一致
        SignUtil.checkSign(map,singKey);
        String hosScheduleId = (String) map.get("hosScheduleId");
        scheduleService.removeSchedule(hoscode,hosScheduleId);
        return Result.ok();
    }





}
