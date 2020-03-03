package cn.luotuoyulang.common.exception;

import cn.luotuoyulang.common.enums.ResultEnum;

/**
 * @Description 业务异常
 * @Classname ServiceException
 * @Date 2020/3/3 12:11
 * @Created by liuyuhu
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    public BusinessException() {
        super();
    }

    public BusinessException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
