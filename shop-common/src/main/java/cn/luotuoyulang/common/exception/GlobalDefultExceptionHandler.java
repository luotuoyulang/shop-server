package cn.luotuoyulang.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 进行全局异常处理
 * @Classname GlobalDefultExceptionHandler
 * @Date 2020/3/3 13:36
 * @Created by liuyuhu
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {
    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defultExcepitonHandler(HttpServletRequest request, Exception e) {
        return "error" + e.getMessage();
    }
}
