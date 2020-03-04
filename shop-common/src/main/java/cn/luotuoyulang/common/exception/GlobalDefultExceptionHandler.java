package cn.luotuoyulang.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 进行全局异常处理
 * @Classname GlobalDefultExceptionHandler
 * @Date 2020/3/3 13:36
 * @Created by liuyuhu
 */
@RestControllerAdvice
public class GlobalDefultExceptionHandler {
    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    public String defultExcepitonHandler(HttpServletRequest request, Exception e) {
        return "error" + e.getMessage();
    }

    @ExceptionHandler(BusinessException.class)
    public String defultExcepitonHandler(HttpServletRequest request, BusinessException e) {
        System.out.println("***********************"+e.getCode());
        System.out.println("***********************"+e.getMsg());
        System.out.println("***********************"+e.getMessage());
        return "error" + e.getMessage();
    }
}
