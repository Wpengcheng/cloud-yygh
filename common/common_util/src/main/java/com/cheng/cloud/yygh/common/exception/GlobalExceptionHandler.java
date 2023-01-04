package com.cheng.cloud.yygh.common.exception;

import com.cheng.cloud.yygh.common.result.Result;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @User Administrator
 * @Classname GlobalExceptionHandler
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-17:45
 * @Version 1.0
 */

@ApiModel(value = "全局异常处理类")
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    @ResponseBody
    @ExceptionHandler(YyghException.class)
    public Result error(YyghException e){
        e.printStackTrace();
        return Result.fail();
    }


}
