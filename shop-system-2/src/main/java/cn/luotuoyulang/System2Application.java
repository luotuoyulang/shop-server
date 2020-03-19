package cn.luotuoyulang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Classname SystemApplication
 * @Date 2020/3/2 20:11
 * @Created by liuyuhu
 */
@EnableEurekaClient
@SpringBootApplication
//@EnableCaching
public class System2Application {

    public static void main(String[] args) {
        SpringApplication.run(System2Application.class,args);
    }
}
