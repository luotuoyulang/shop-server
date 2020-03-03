package cn.luotuoyulang.system.service;

import cn.luotuoyulang.system.entity.DogEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Classname DogService
 * @Date 2020/3/3 0:29
 * @Created by liuyuhu
 */
public interface DogService {

    /**
     * @Description 查询狗
     * @param id
     * @return {@link {@link DogEntity}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 0:31
     */
    DogEntity getDog(Integer id);
}
