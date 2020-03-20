package cn.luotuoyulang.system.controller;

import cn.luotuoyulang.common.entity.PageResult;
import cn.luotuoyulang.common.entity.BaseResult;
import cn.luotuoyulang.common.utils.ResultUtil;
import cn.luotuoyulang.system.entity.DogEntity;
import cn.luotuoyulang.system.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public BaseResult<DogEntity> getDog(@RequestParam Integer id){
        log.info("查询狗  id [{}] " , id);
        System.err.println("*************111111111*******");
//        if(true){
//            throw new RuntimeException("我错啦，我是system  one ");
//        }
        return ResultUtil.success(dogService.getDog(id));
    }

    /**
     * @Description 查询所有狗
     * @param pageNum
     * @param pageSize
     * @return {@link {@link String}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/4 15:19
     */
    @GetMapping("/findDog")
    public PageResult<DogEntity> findDog(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
                          @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        List<DogEntity> dog = dogService.findDog(pageNum, pageSize);
        return ResultUtil.page(dog);
    }
}
