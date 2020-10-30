package com.xinggq.producer.service;

import com.xinggq.producer.ProducerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class SimpleMessageServiceTest {

  @Autowired
  private MessageProducer messageProducer;

  @Test
  public void selectById(){

    messageProducer.processA();
  }

}