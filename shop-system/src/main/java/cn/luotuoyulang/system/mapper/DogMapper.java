package cn.luotuoyulang.system.mapper;

import cn.luotuoyulang.system.entity.DogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Classname DogMapper
 * @Date 2020/3/2 23:53
 * @Created by liuyuhu
 */
public interface DogMapper {

    /**
     * @param id
     * @return {@link {@link DogEntity}}
     * @throws
     * @Description 查询狗
     * @author liuyuhu
     * @date 2020/3/3 0:27
     */
    DogEntity getDog(@Param("id") Integer id);

    /**
     * @Description 查询狗列表
     * @param
     * @return {@link {@link List< DogEntity>}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/4 15:18
     */
    List<DogEntity> findDog();
}