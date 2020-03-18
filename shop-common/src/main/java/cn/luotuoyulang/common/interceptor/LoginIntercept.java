package cn.luotuoyulang.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Classname LoginIntercept
 * @Date 2020/3/15 12:42
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
public class LoginIntercept implements HandlerInterceptor {
    
    /**
     * @Description 在请求处理之前进行调用（Controller方法调用之前）
     * @param request
     * @param response
     * @param handler
     * @return {@link {@link boolean}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/15 12:54
     */           
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod())){
            return true;
        }
        System.out.println("preHandle");
        return true;
    }
    
    /**
     * @Description 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/3/15 12:54
     */       
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
    
    /**
     * @Description 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return {@link }
     * @throws
     * @author liuyuhu
     * @date 2020/3/15 12:54
     */       
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
