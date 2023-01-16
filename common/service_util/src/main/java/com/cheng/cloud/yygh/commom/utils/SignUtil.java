package com.cheng.cloud.yygh.commom.utils;

import com.cheng.cloud.yygh.common.exception.YyghException;
import com.cheng.cloud.yygh.common.result.ResultCodeEnum;


import java.util.Map;

/**
 * @User Administrator
 * @Classname SignUtil
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-15-14:04
 * @Version 1.0
 */

public class SignUtil {


    //检验签名
    public static void checkSign(Map<String, Object> map,String singKey){
        //经过二次加密的签名
        String sing = (String) map.get("sign");
        String singKeyMd5 = MD5.encrypt(singKey);
        if (!sing.equals(singKeyMd5)){
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
    }
}
