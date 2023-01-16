package com.cheng.cloud.yygh.model.hosp;

import com.cheng.cloud.yygh.model.base.BaseMongoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @User Administrator
 * @Classname DepartmentDto
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:11
 * @Version 1.0
 */
@Data
@Document("Department")
@ApiModel(description = "部门")
public class Department extends BaseMongoEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "医院编号")
    @Indexed //普通索引
    private String hoscode;

    @ApiModelProperty(value = "科室编号")
    @Indexed(unique = true) //唯一索引
    private String depcode;

    @ApiModelProperty(value = "科室名称")
    private String depname;

    @ApiModelProperty(value = "科室描述")
    private String intro;

    @ApiModelProperty(value = "大科室编号")
    private String bigcode;

    @ApiModelProperty(value = "大科室名称")
    private String bigname;
}
