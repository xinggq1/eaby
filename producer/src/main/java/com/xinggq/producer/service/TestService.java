package com.xinggq.producer.service;

import com.xinggq.producer.entity.Test;
import com.xinggq.producer.repository.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private TestMapper testMapper;

  public Test selectById(Integer id){
    Test test = testMapper.selectById(id);
    return test;
  }

}
