package com.cheng.cloud.yygh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.cloud.yygh.commom.utils.MD5;
import com.cheng.cloud.yygh.common.exception.YyghException;
import com.cheng.cloud.yygh.common.result.Result;
import com.cheng.cloud.yygh.model.hosp.HospitalSetDto;
import com.cheng.cloud.yygh.service.HospitalSetService;
import com.cheng.cloud.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * @User Administrator
 * @Classname HospitalSetController
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:51
 * @Version 1.0
 */
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet/")
public class HospitalSetController {


    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation("获取所有信息")
    @GetMapping("findAll")
    public Result findAllHospitalSet(){
        return Result.ok(hospitalSetService.list());
    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("delete/{id}")
    public Result DeleteById(@PathVariable Long id){
        boolean flag = hospitalSetService.removeById(id);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("分页条件查询")
    @PostMapping("queryByPage")
    public Result queryByPage(@RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo){//@RequestBody(required = false) 接收前端传递的json数据，可以为null
        Page<HospitalSetDto> page = new Page<>(1, 10);
        QueryWrapper<HospitalSetDto> queryWrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        if (StringUtils.isEmpty(hosname)){
            queryWrapper.like("hosname",hosname);
        }
        if (StringUtils.isEmpty(hoscode)){
            queryWrapper.eq("hoscode",hoscode);

        }
        Page<HospitalSetDto> hospitalSetDtoPage = hospitalSetService.page(page, queryWrapper);
        return Result.ok(hospitalSetDtoPage);
    }


    @ApiOperation("添加医院设置")
    @PostMapping("addHospitalSet")
    public Result addHospitalSet(@RequestBody HospitalSetDto hospitalSetDto){
        //设置医院状态
        hospitalSetDto.setStatus(1);
        //生成签名秘钥
        String md5Encode = MD5.MD5Encode(System.currentTimeMillis() + "" + new Random().nextInt(1000), "UTF-8", false);
        hospitalSetDto.setSignKey(md5Encode);
        boolean flag = hospitalSetService.save(hospitalSetDto);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询医院设置")
    @GetMapping("queryHospitalSetById/{id}")
    public Result queryHospitalSetById(@PathVariable Long id){
        return Result.ok(hospitalSetService.getById(id));

    }

    @ApiOperation("修改医院设置信息")
    @PostMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSetDto hospitalSetDto){
        boolean flag = hospitalSetService.updateById(hospitalSetDto);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("批量删除医院设置信息")
    @DeleteMapping ("deleteHospitalSetByIds")
    public Result deleteHospitalSetByIds(@RequestBody List<Long> ids){
        boolean flag = hospitalSetService.removeByIds(ids);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("修改医院状态信息")
    @PostMapping ("updateHospitalSetStatus/{id}/{status}")
    public Result updateHospitalSetStatus(@PathVariable Long id,@PathVariable Integer status){
        HospitalSetDto hospitalSetDto = hospitalSetService.getById(id);
        if (hospitalSetDto==null){
            return Result.fail("医院不存在");
        }
        hospitalSetDto.setStatus(status);
        return Result.ok(hospitalSetService.updateById(hospitalSetDto));
    }

    @ApiOperation("发送签名秘钥")
    @PostMapping ("sendSingKey/{id}")
    public Result sendSingKey(@PathVariable Long id){
        HospitalSetDto hospitalSetDto = hospitalSetService.getById(id);
        if (hospitalSetDto==null){
            return Result.fail("医院不存在");
        }
        String hoscode = hospitalSetDto.getHoscode();
        String hosname = hospitalSetDto.getHosname();

        return Result.ok();
    }


}
