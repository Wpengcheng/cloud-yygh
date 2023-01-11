package com.cheng.cloud.yygh.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.cloud.yygh.cmn.mapper.DictMapper;
import com.cheng.cloud.yygh.model.cmn.DictDto;
import com.cheng.cloud.yygh.vo.cmn.DictExcelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @User Administrator
 * @Classname DictListener
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-08-12:25
 * @Version 1.0
 */

public class DictListener extends AnalysisEventListener<DictExcelVO> {


    private DictMapper dictMapper;

    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //读取excel表格数据并添加
    @Override
    public void invoke(DictExcelVO dictExcelVO, AnalysisContext context) {
        DictDto dictDto = new DictDto();
        BeanUtils.copyProperties(dictExcelVO,dictDto);
        dictMapper.insert(dictDto);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
