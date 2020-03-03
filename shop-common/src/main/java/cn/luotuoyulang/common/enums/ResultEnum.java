package cn.luotuoyulang.common.enums;

import lombok.Data;

/**
 * @Description TODO
 * @Classname ResultEnum
 * @Date 2020/3/3 12:50
 * @Created by liuyuhu
 */
public enum ResultEnum {
    CODE_200(200, "成功"),
    CODE_400(400, "错误的请求参数"),

    CODE_500(500, "内部服务器错误");
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
