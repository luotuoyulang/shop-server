package cn.luotuoyulang.system.service.impl;

import cn.luotuoyulang.system.entity.DogEntity;
import cn.luotuoyulang.system.mapper.DogMapper;
import cn.luotuoyulang.system.service.DogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @Description 查询所以有狗
     * @param pageNum
     * @param pageSize
     * @return {@link {@link List< DogEntity>}}
     * @throws
     * @author liuyuhu
     * @date 2020/3/4 15:15
     */
    @Override
    public List<DogEntity> findDog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return dogMapper.findDog();
    }
}
