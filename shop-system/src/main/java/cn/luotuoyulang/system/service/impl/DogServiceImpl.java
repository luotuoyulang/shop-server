package cn.luotuoyulang.system.service.impl;

import cn.luotuoyulang.system.entity.DogEntity;
import cn.luotuoyulang.system.mapper.DogMapper;
import cn.luotuoyulang.system.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Classname DogServiceImpl
 * @Date 2020/3/3 0:31
 * @Created by liuyuhu
 */
@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogMapper dogMapper;

    /**
     * @Description 查询狗
     * @param id
     * @return {@link {@link DogEntity}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/3 0:32
     */
    @Override
    public DogEntity getDog(Integer id) {
        return dogMapper.getDog(id);
    }
}
