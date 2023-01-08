package com.cheng.cloud.yygh.cmn.controller;

import com.cheng.cloud.yygh.cmn.service.DictService;
import com.cheng.cloud.yygh.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @User Administrator
 * @Classname ServiceCmnController
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-06-19:52
 * @Version 1.0
 */
@Api(tags = "数据字典管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/cmn/dict/")
public class DictController {

    @Autowired
    private DictService dictService;


    @ApiOperation("根据id查询子节点数据")
    @GetMapping("listChildDict/{id}")
    public Result listChildDict(@PathVariable Long id){
        return Result.ok(dictService.listChildDict(id));
    }

    @ApiOperation("导出")
    @GetMapping("exportDict")
    public void exportDict(HttpServletResponse response){
        dictService.exportDict(response);
    }

    @ApiOperation("导入")
    @GetMapping("importDict")
    public Result importDict(MultipartFile file){
        dictService.importDict(file);
        return Result.ok();
    }





}
