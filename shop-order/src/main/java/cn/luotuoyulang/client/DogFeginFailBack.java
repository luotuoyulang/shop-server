package cn.luotuoyulang.client;

import cn.luotuoyulang.common.entity.BaseResult;
import cn.luotuoyulang.common.enums.ResultEnum;
import cn.luotuoyulang.common.utils.ResultUtil;
import cn.luotuoyulang.entitys.DogEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Classname DogFeginFailBack
 * @Date 2020/3/20 11:08
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Component
public class DogFeginFailBack implements FallbackFactory<DogFeignClient> {

    @Override
    public DogFeignClient create(Throwable throwable) {
        return new DogFeignClient() {
            @Override
            public BaseResult<DogEntity> getDog(Integer id) {
                System.err.println("*********************");
                System.out.println(throwable.getMessage());
                System.err.println("*********************"+id);
                return ResultUtil.error(ResultEnum.PAGEHELPER_ERROR);
            }
        };
    }
}
