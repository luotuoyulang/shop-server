package cn.luotuoyulang.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Classname PoolConfig
 * @Date 2020/3/5 10:47
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Configuration
@ConfigurationProperties(prefix = "thread.push.task.pool")
@Data
public class PoolConfig {

    /**
     * 核心线程池数
     */
    private int corePoolSize = 10;

    /**
     * 最大线程池数
     */
    private int maxPoolSize = 100;

    /**
     * 允许线程的空闲时间60秒
     */
    private int keepAliveSeconds = 60;

    /**
     * 缓冲队列200
     */
    private int queueCapacity = 200;
}
