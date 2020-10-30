package com.xinggq.consumer.mq;


import com.google.gson.Gson;
import com.xinggq.producerapi.dto.MqMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

@RabbitListener(queues = "simple_message")
public class RabbitMqListener {


  @RabbitHandler
  public void process(MqMessage<String> testMessage) {
    Gson gson = new Gson();
    System.out.println("DirectReceiver消费者收到消息  : " + gson.toJson(testMessage));
//    throw new RuntimeException();
  }



}