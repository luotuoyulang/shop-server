package cn.luotuoyulang.controller;

import cn.luotuoyulang.client.DogFeignClient;
import cn.luotuoyulang.common.entity.BaseResult;
import cn.luotuoyulang.entitys.DogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Classname HelloController
 * @Date 2020/3/19 23:54
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@RestController
public class HelloController {

    @Autowired
    private DogFeignClient dogFeignClient;

    @GetMapping("/hello")
    public BaseResult<DogEntity> hello(){
        System.err.println("12312312312312312312");
        return dogFeignClient.getDog(1);
    }
}
