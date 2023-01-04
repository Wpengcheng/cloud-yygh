package com.cheng.cloud.yygh.vo.hosp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @User Administrator
 * @Classname HospitalSetQueryVo
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-14:11
 * @Version 1.0
 */
@Data
@ApiModel(value = "医院设置条件查询类")
public class HospitalSetQueryVo {

    @ApiModelProperty("医院名称")
    private String hosname;

    @ApiModelProperty("医院编码")
    private String hoscode;


}
