package com.cheng.cloud.yygh.model.cmn;

import com.baomidou.mybatisplus.annotation.*;
import com.cheng.cloud.yygh.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @User Administrator
 * @Classname Dict
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-06-19:58
 * @Version 1.0
 */
@Data
@ApiModel(description = "数据字典")
@TableName("dict")
public class DictDto{

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "id")
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

    @ApiModelProperty(value = "上级id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "值")
    @TableField("value")
    private String value;

    @ApiModelProperty(value = "编码")
    @TableField("dict_code")
    private String dictCode;

    @ApiModelProperty(value = "是否包含子节点")
    @TableField(exist = false)
    private boolean hasChildren;

}
