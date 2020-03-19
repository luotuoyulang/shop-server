package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Classname GatwayApplication
 * @Date 2020/3/19 16:21
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */

@EnableEurekaClient
@SpringBootApplication
public class GatwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatwayApplication.class,args);
    }
}
