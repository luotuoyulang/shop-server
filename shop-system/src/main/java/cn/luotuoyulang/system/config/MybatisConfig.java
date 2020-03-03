package cn.luotuoyulang.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MybatisConfig
 * @Classname MybatisConfig
 * @Date 2020/3/2 23:42
 * @Created by liuyuhu
 */
@MapperScan("cn.luotuoyulang.system.mapper")
@Configuration
public class MybatisConfig {


}
