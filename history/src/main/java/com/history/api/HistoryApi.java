package com.history.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.history.model.History;
import com.history.model.Order;
import com.history.service.HistoryService;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class HistoryApi {

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  HistoryService historyService;

  @KafkaListener(topics = "test", groupId = "group-id")
  public String add(String message){
    ObjectMapper Obj = new ObjectMapper();
    History history = new History();
    try {
      Order order = Obj.readValue(message, Order.class);
      history.setId(order.getId());
      history.setState(order.getState());
      history.setDate(new Date());
      history.setName(order.getName());
      historyService.insert(history);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return history.getId();
  }
}
