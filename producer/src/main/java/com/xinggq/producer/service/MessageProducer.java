package com.xinggq.producer.service;


import com.xinggq.producer.entity.Message;
import com.xinggq.producer.mq.MqSender;
import com.xinggq.producerapi.dto.MqMessage;
import com.xinggq.producerapi.dto.Mqcontext;
import com.xinggq.producerapi.enums.RoutKeyingEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MessageProducer {

  @Autowired
  private MessageService messageService;

  @Autowired
  private MqSender mqSender;

  @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
  public void processA(){
    //写入业务逻辑
    log.info("写入业务逻辑,修改本地数据库");
    //记录消息表
    log.info("开始记录本地消息表");
    Message message = new Message("这个是消息内容");
    messageService.insert(message);
    //发送到消息队列
    log.info("开始发送到mq");
    MqMessage mqMessage = MqMessage.buildMsg(new Mqcontext(),message);
    mqSender.sendToEabyExchange(mqMessage, RoutKeyingEnum.SIMPLE_MESSAGE);
  }



}
