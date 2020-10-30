package com.xinggq.producerapi.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MqMessage<T> implements Serializable {

  private Mqcontext content;

  private T data;

  public static<T> MqMessage buildMsg(Mqcontext content,T data){
    return new MqMessage(content,data);
  }

  private MqMessage(Mqcontext content,T data){
    this.content = content;
    this.data = data;
  }

}
