package com.xinggq.producer.mq;


import com.xinggq.producerapi.dto.MqMessage;
import com.xinggq.producerapi.enums.ExchangeEnum;
import com.xinggq.producerapi.enums.RoutKeyingEnum;
import java.util.Properties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSender {

  @Autowired
  private AmqpTemplate rabbitAmqpTemplate;

  @Autowired
  private RabbitAdmin rabbitAdmin;


  public void sendToEabyExchange(MqMessage msg, RoutKeyingEnum routKeyingEnum){
//    if(!isQueueExists(routKeyingEnum.getKey())){
//      Map<String, Object> args = new HashMap<>();
////      args.put("x-expires", 2592000000L);
////      args.put("x-queue-mode", "lazy");
//      Queue queue = new Queue(routKeyingEnum.getKey(), true, false, true);
//      rabbitAdmin.declareQueue(queue);
//    }
    rabbitAmqpTemplate.convertAndSend(ExchangeEnum.EABY_WEEXCHANGE.getExchangeName(), routKeyingEnum.getKey(), msg);
  }


  private boolean isQueueExists(String queueName) {
    Properties props = rabbitAdmin.getQueueProperties(queueName);
    return props != null;
  }

}
