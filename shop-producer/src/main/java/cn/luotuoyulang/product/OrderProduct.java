package cn.luotuoyulang.product;

import cn.luotuoyulang.entity.DogEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Classname OrderProduct
 * @Date 2020/3/4 10:16
 * @Created by liuyuhu
 * @Email 17600520726@163.com
 */
@Slf4j
@RestController
public class OrderProduct {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${imps.record.exchange.name}")
    private String queueType;

    @Value("${imps.record.order.key.name}")
    private String rootingKing;

    @GetMapping("/puductOrder")
    public String puductOrder()  {
        try{
            rabbitTemplate.setExchange(queueType);
            rabbitTemplate.setRoutingKey(rootingKing);
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

            DogEntity dog = new DogEntity();
            dog.setId(1);
            dog.setAge("小米");
            Message msg= MessageBuilder.withBody(objectMapper.writeValueAsBytes(dog)).setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
                    .build();
            rabbitTemplate.convertAndSend(msg);
            return "法功成功。。。。。。。。。。。";
        }
        catch (Exception se){
            log.error(se.getMessage());
            throw new RuntimeException("调用失败。。。。。。");
        }
    }
}
