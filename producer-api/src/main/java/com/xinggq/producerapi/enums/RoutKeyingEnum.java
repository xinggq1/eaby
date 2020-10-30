package com.xinggq.producerapi.enums;


import lombok.Getter;

@Getter
public enum RoutKeyingEnum {

  SIMPLE_MESSAGE("simple_message","简单消息路由键");

  private String key;
  private String desc;

  private RoutKeyingEnum(String key,String desc){
    this.desc = desc;
    this.key = key;
  }

}
