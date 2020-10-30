package com.xinggq.producerapi.enums;


import lombok.Getter;

@Getter
public enum ExchangeEnum {

  EABY_WEEXCHANGE("eaby_exchange","eaby的路由器");

  private String exchangeName;

  private String desc;

  ExchangeEnum(String exchangeName,String desc){
    this.desc = desc;
    this.exchangeName = exchangeName;
  }
}
