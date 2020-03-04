package cn.luotuoyulang.common.enums;

import lombok.Data;

/**
 * @Description TODO
 * @Classname ResultEnum
 * @Date 2020/3/3 12:50
 * @Created by liuyuhu
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 参数有误
     */
    PARAM_ERROR(4000, "param is error"),

    /**
     * 业务出错
     */
    ERROR(500, "error"),

    /**
     * 分页错误码
     */
    PAGEHELPER_ERROR(9001, "pagehelper is error");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
