package com.cheng.cloud.yygh.cmn.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.cloud.yygh.cmn.mapper.DictMapper;
import com.cheng.cloud.yygh.cmn.service.DictService;
import com.cheng.cloud.yygh.common.result.Result;
import com.cheng.cloud.yygh.model.cmn.DictDto;
import com.cheng.cloud.yygh.vo.cmn.DictExcelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @User Administrator
 * @Classname DictServiceImpl
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-06-20:02
 * @Version 1.0
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, DictDto> implements DictService  {

    @Override
    public List<DictDto> listChildDict(Long id) {
        QueryWrapper<DictDto> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<DictDto> dictDtos = baseMapper.selectList(wrapper);
        dictDtos.forEach(d->{
            d.setHasChildren(isChild(d.getId()));
        });
        return dictDtos;
    }

    @Override
    public void exportDict(HttpServletResponse response) {
        //设置信息
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName ="dict";
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        List<DictDto> dictDtos = baseMapper.selectList(null);
        List<DictExcelVO> dictExcelVOS = new ArrayList<>();
        dictDtos.forEach(d->{
            DictExcelVO dictExcelVO = new DictExcelVO();
            BeanUtils.copyProperties(d,dictExcelVO);
            dictExcelVOS.add(dictExcelVO);
        });
        try {
            //导出实现
            EasyExcel.write(response.getOutputStream(),DictExcelVO.class).sheet("dict").doWrite(dictExcelVOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Result importDict(MultipartFile file) {

        return null;
    }


    //判断是否有子节点
    private boolean isChild(Long id) {
        QueryWrapper<DictDto> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        return baseMapper.selectCount(wrapper)>0;
    }
}
