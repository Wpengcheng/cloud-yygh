package com.cheng.cloud.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.cloud.yygh.common.result.Result;
import com.cheng.cloud.yygh.model.cmn.DictDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @User Administrator
 * @Classname DictService
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-06-20:02
 * @Version 1.0
 */
public interface DictService extends IService<DictDto> {

    List<DictDto> listChildDict(Long id);


    void exportDict(HttpServletResponse response);

    Result importDict(MultipartFile file);
}
