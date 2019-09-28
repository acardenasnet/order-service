package com.dou.javadevdaymx2019.orderservice.service;

import com.dou.javadevdaymx2019.orderservice.domain.Order;
import com.dou.javadevdaymx2019.orderservice.exception.NotFoundException;
import com.dou.javadevdaymx2019.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public List<Order> getAll() {
    List<Order> orders = new LinkedList<>();
    orderRepository.findAll().forEach(orders::add);
    return orders;
  }
  public Order create(Order order) {
      return orderRepository.save(order);
  }

  public Order getById(Long id) {
    return orderRepository.findById(id).orElseThrow(NotFoundException::new);
  }

}
