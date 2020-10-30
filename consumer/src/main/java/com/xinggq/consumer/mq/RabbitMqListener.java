package com.xinggq.consumer.mq;


import java.util.Map;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

@RabbitListener(queues = "simple_message")
public class RabbitMqListener {


  @RabbitHandler
  public void process(String testMessage) {
    System.out.println("DirectReceiver消费者收到消息  : " + testMessage);
  }



}