package com.order.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.model.Order;
import com.order.service.OrderService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderApi {

  @Autowired
  OrderService orderService;

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  @PostMapping
  public void insertOrder(@RequestBody Order order){
    Order order1 = orderService.add(order);
    if(orderService.getById(order1.getId()) != null){
      ObjectMapper Obj = new ObjectMapper();
      try {
        String jsonStr = Obj.writeValueAsString(order1);
        kafkaTemplate.send("test",jsonStr);
        System.out.println(kafkaTemplate.partitionsFor("partition"));
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
