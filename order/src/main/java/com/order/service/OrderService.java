package com.order.service;

import com.order.model.Order;
import com.order.repository.OrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  public Order add(Order order){
    return orderRepository.insert(order);
  }

  public Order update(Order order){
    return orderRepository.save(order);
  }

  public Optional<Order> getById(String id){
    return orderRepository.findById(id);
  }
}
