package com.cheng.cloud.yygh.common.exception;

import com.cheng.cloud.yygh.common.result.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @User Administrator
 * @Classname YyghException
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-17:54
 * @Version 1.0
 */
@Data
@ApiModel(value = "自定义异常")
public class YyghException extends RuntimeException{

    @ApiModelProperty("异常状态码")
    private Integer code;

    public YyghException(Integer code,String message){
        super(message);
        this.code = code;
    }
    public YyghException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "YyghException{" +
                "code=" + code +
                "message=" + this.getMessage() +
                '}';
    }
}
