package cn.luotuoyulang.common.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description TODO
 * @Classname IpLogConfig
 * @Date 2020/3/2 22:29
 * @Created by liuyuhu
 */
@Slf4j
public class IpLogConfig extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("IPLogConfig getLocalHostError", e);
        }
        return "";
    }
}