package com.xinggq.producer.entity;


import com.xinggq.common.utils.SnowflakeIdWorker;
import com.xinggq.producerapi.enums.MessageStatus;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Message implements Serializable {

  @Id
  //使用mysql的主键自增策略，不创建hibernate_sequence表
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "msg_identical_id" , nullable = true, length = 20)
  private String msgIdenticalId;

  @Column(name = "status" , nullable = true, length = 1)
  private String status;

  @Column(name = "msg_content" , nullable = true, length = 500)
  private String msgContent;

  public Message() { }

  public Message(String msgContent){
    this.msgIdenticalId = String.valueOf(SnowflakeIdWorker.generateId());
    this.status = MessageStatus.SENDED_NOT_CONFIRM.getCode();
    this.msgContent = msgContent;
  }



//  @Column(name = "msg_content" , nullable = true, length = 500)
//  private java.sql.Timestamp createtime;
//  private java.sql.Timestamp ts;
}
