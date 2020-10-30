package com.xinggq.producer.mq;


import com.xinggq.producerapi.dto.MqMessage;
import com.xinggq.producerapi.enums.ExchangeEnum;
import com.xinggq.producerapi.enums.RoutKeyingEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSender {

  @Autowired
  private AmqpTemplate rabbitAmqpTemplate;


  public void sendToEabyExchange(MqMessage msg, RoutKeyingEnum routKeyingEnum){
    rabbitAmqpTemplate.convertAndSend(ExchangeEnum.EABY_WEEXCHANGE.getExchangeName(), routKeyingEnum.getKey(), msg);
  }



}
