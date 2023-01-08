package com.cheng.cloud.yygh.vo.cmn;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @User Administrator
 * @Classname DictExcelVO
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-08-11:49
 * @Version 1.0
 */
@Data
public class DictExcelVO {

    @ExcelProperty(value = "id",index = 0)
    private Long id;

    @ExcelProperty(value = "父id",index = 1)
    private Long parentId;

    @ExcelProperty(value = "名称",index = 2)
    private String name;

    @ExcelProperty(value = "值",index = 3)
    private String value;

    @ExcelProperty(value = "编码",index = 4)
    private String dictCode;

}
