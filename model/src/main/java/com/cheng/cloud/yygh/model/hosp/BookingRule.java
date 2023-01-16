package com.cheng.cloud.yygh.model.hosp;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.util.List;
/**
 * @User Administrator
 * @Classname BookingRule
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-12-11:10
 * @Version 1.0
 */
@Data
@ApiModel(description = "预约规则")
@Document("BookingRule")
public class BookingRule {

    @ApiModelProperty(value = "预约周期")
    private Integer cycle;

    @ApiModelProperty(value = "放号时间")
    private String releaseTime;

    @ApiModelProperty(value = "停挂时间")
    private String stopTime;

    @ApiModelProperty(value = "退号截止天数（如：就诊前一天为-1，当天为0）")
    private Integer quitDay;

    @ApiModelProperty(value = "退号时间")
    private String quitTime;

    @ApiModelProperty(value = "预约规则")
    private List<String> rule;

    /**
     *
     * @param rule
     */
    public void setRule(String rule) {
        if(!StringUtils.isEmpty(rule)) {
            this.rule = JSONArray.parseArray(rule, String.class);
        }
    }

}
