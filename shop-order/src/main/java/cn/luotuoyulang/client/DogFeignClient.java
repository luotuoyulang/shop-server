package cn.luotuoyulang.client;

import cn.luotuoyulang.common.entity.BaseResult;
import cn.luotuoyulang.entitys.DogEntity;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Classname DogFeignClient
 * @Date 2020/3/20 0:05
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@FeignClient(name = "SYSTEM" ,fallbackFactory = DogFeginFailBack.class)
public interface DogFeignClient {

//    @RequestLine("GET /simple/{id}")
//    public User getUserById(@Param("id") Long id);
//
//    @RequestLine("POST /getUserById")
//    public User postUserById(@RequestBody User user);

    @GetMapping("/getDog")
    public BaseResult<DogEntity> getDog(@RequestParam Integer id);
}

