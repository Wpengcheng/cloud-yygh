package com.cheng.cloud.yygh.common.result;

import lombok.Data;
import lombok.Getter;
import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * @User Administrator
 * @Classname ResultEnum
 * @Project yygh_parent
 * @Description TODO
 * @Author wpcheng
 * @Create 2023-01-03-12:19
 * @Version 1.0
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(20000,"成功"),
    FAIL(201,"失败"),
    PARAM_ERROR(202,"参数不正确"),
    SERVICE_ERROR(203,"服务异常"),
    DATA_ERROR(204,"数据异常"),
    DATA_UPDATE_ERROR(205,"数据版本异常"),

    LOGIN_AUTH(208,"未登录"),
    PERMISSION(209,"没有权限"),

    CODE_ERROR(210,"验证码错误"),
    LOGIN_DISABLE_ERROR(212,"用户被禁用"),
    REGISTER_MOBLE_ERROR(213,"手机号已被使用"),
    LOGIN_AURH(214,"需要登录"),
    LOGIN_ACL(214,"没有权限"),

    URL_ENCODE_ERROR(216,"URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR(217,"非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD(218,"获取accessToken失败"),
    FETCH_USERINFO_ERROR(219,"获取用户信息失败"),

    PAY_RUN(220,"支付中"),
    CANCEL_ORDER_FAIL(225,"取消订单失败"),
    CANCEL_ORDER_ON(225,"不能取消预约"),

    HOSCODE_EXIST(230,"医院编号已经存在"),
    NUMBER_ACL(240,"可预约号不足"),
    TIME_ACL(250,"当前时间不可预约"),

    SIGN_ERROR(330,"签名错误"),
    HOSPITAL_OPEN(310,"医院未开通，暂时不能访问"),
    HOSPITAL_LOCK(320,"医院被锁定，暂时不能访问"),
    ;





    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
