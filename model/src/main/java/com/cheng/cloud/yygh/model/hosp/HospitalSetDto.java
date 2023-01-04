package com.cheng.cloud.yygh.model.hosp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cheng.cloud.yygh.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @User Administrator
 * @Classname HospitalSet
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:20
 * @Version 1.0
 */

@Data
@ApiModel(description = "医院设置")
@TableName("hospital_set")
public class HospitalSetDto extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "医院名称")
    @TableField("hosname")
    private String hosname;


    @ApiModelProperty(value = "医院编号")
    @TableField("hoscode")
    private String hoscode;

    @ApiModelProperty(value = "基础路径")
    @TableField("api_url")
    private String apiUrl;

    @ApiModelProperty(value = "签名秘钥")
    @TableField("sign_key")
    private String signKey;

    @ApiModelProperty(value = "联系人名称")
    @TableField("contacts_name")
    private String contactsName;

    @ApiModelProperty(value = "联系人号码")
    @TableField("contacts_phone")
    private String contactsPhone;

    @ApiModelProperty(value = "医院状态 0：禁用，1：可用")
    @TableField("status")
    private Integer status;









}
