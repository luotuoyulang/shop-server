package cn.luotuoyulang.cosumer;

import cn.luotuoyulang.entity.DogEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Classname OrderConsumer
 * @Date 2020/3/4 10:50
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Slf4j
@RestController
public class OrderConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${imps.record.order.queue.name}",containerFactory = "singleListenerContainer")
    public void consumeOrder(@Payload byte[] message) {
        log.info("===开始消费==========rabbitmq来自===============message[{}]=========开始消费==== ,", "imps.record.order.queue.name");
        try {
            DogEntity dog = objectMapper.readValue(message, DogEntity.class);
            System.err.println("====================="+dog);
//            recodeLogService.save(impsRecodeLog);
        } catch (Exception e) {
            log.error("=============rabbitmq来自===============message[{}]=========出错==== ,"+ e.getMessage(), "imps.record.order.queue.name");
        }
    }
}
