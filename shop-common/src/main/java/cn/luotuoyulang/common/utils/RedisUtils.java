package cn.luotuoyulang.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public <T> T getObj(String key){
        return  (T)redisTemplate.opsForValue().get(key);
    }

    public void setObj(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

