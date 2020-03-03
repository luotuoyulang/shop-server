package cn.luotuoyulang.system.controller;

import cn.luotuoyulang.system.entity.DogEntity;
import cn.luotuoyulang.system.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Classname TestController
 * @Date 2020/3/2 20:18
 * @Created by liuyuhu
 */
@Slf4j
@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/getDog")
    public DogEntity getDog(Integer id){
//        if(true){
//            throw new RuntimeException("是不是这个异常呢");
//        }
        log.info("查询狗  id [{}] " , id);
        return dogService.getDog(id);
    }
}
