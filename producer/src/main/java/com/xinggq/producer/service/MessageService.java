package com.xinggq.producer.service;

import com.xinggq.producer.entity.Message;
import com.xinggq.producer.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private MessageRepository messageMapper;

  void insert(Message message){
    messageMapper.save(message);
  }
}
