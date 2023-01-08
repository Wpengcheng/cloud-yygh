package com.cheng.cloud.yygh.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @User Administrator
 * @Classname BaseEntity
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-02-21:24
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;


    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "0：未删除；1：已删除")
    @TableLogic//逻辑删除
    @TableField("is_deleted")
    private Integer isDeleted;


//    @ApiModelProperty(value = "其他参数")
//    @TableField(exist = false)
//    private Map param = new HashMap<String,Object>();

}
