package cn.luotuoyulang.system.mapper;

import cn.luotuoyulang.system.entity.DogEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Classname DogMapper
 * @Date 2020/3/2 23:53
 * @Created by liuyuhu
 */
public interface DogMapper {

    /**
     * @Description 查询狗
     * @param id
     * @return {@link {@link DogEntity}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 0:27
     */
    DogEntity getDog(@Param("id") Integer id);
}
