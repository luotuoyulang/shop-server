package cn.luotuoyulang.common.config;

import cn.luotuoyulang.common.interceptor.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 自定义拦截器
 * @Classname InterceptorConfig
 * @Date 2020/3/15 12:48
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login",
                        "/upload"
                );

    }
}
