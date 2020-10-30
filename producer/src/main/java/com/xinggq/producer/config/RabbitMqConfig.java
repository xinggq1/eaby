package com.xinggq.producer.config;

import com.xinggq.producerapi.enums.ExchangeEnum;
import com.xinggq.producerapi.enums.RoutKeyingEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {


  @Bean
  public DirectExchange exchange(){
    return new DirectExchange(ExchangeEnum.EABY_WEEXCHANGE.getExchangeName(), true, true);
  }
  @Bean
  Queue invoiceClientQueue() {
    return new Queue(RoutKeyingEnum.SIMPLE_MESSAGE.getKey(), true, false, false);
  }

  @Bean
  public Binding bindingInvoiceClentQueue( DirectExchange exchange, Queue queue) {
    return BindingBuilder.bind(queue).to(exchange).with(RoutKeyingEnum.SIMPLE_MESSAGE.getKey());
  }




}
