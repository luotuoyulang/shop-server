package cn.luotuoyulang.system.controller;

import cn.luotuoyulang.common.utils.RedisUtils;
import cn.luotuoyulang.system.entity.DogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description redis 测试 Controller
 * @Classname TestController
 * @Date 2020/3/3 19:36
 * @Created by liuyuhu
 */
@RestController
public class RedisController {

    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/addRedis")
    public String addRedis(){
        DogEntity dogEntity = new DogEntity();
        dogEntity.setAge("12");
        dogEntity.setId(1);
        redisUtils.setObj("a",dogEntity);
        return "success";
    }

    @GetMapping("/getRedis")
    public Object getRedis(){
        DogEntity dogEntity = new DogEntity();
        dogEntity.setAge("12");
        dogEntity.setId(1);
        return redisUtils.getObj("a");
    }
}
