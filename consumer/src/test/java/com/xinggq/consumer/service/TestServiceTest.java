package com.xinggq.consumer.service;


import com.google.gson.Gson;
import com.xinggq.consumer.ConsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class TestServiceTest {

  @Autowired
  private TestService testService;

  @Test
  public void selectById(){
    com.xinggq.consumer.entity.Test test=testService.selectById(123);
    Gson gson = new Gson();
    System.out.printf(gson.toJson(test));
  }

}
