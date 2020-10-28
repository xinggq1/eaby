package com.xinggq.common.enums;


import lombok.Getter;

@Getter
public enum MessageStatus {
  NOT_SEND("","未发送"),
  SENDED_NOT_CONFIRM("1","已发送，未返回"),
  CONFIRM_FAIL("2","已返回，未成功"),
  CONFIRM_SUCCESS("3","已返回，已成功");

  private final String code;

  private final String msg;

  MessageStatus(String code,String msg){
    this.code = code;
    this.msg = msg;
  }

}
