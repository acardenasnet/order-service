package com.dou.javadevdaymx2019.orderservice.controller;

import com.dou.javadevdaymx2019.orderservice.domain.Order;
import com.dou.javadevdaymx2019.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping
  public List<Order> getOrders() {
    return orderService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

    Order order = orderService.getById(id);

    Double disccount = restTemplate
        .getForObject("http://coupon-service/{id}", Double.class, order.getCoupon());
    log.info("Disccount is : {}", disccount);
    order.setTotal(order.getSubtotal() - disccount);

    return ResponseEntity.ok(order);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createOrder(@RequestBody Order order) {
    Order savedOrder = orderService.create(order);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedOrder.getId())
        .toUri();

    return ResponseEntity.created(location).build();
  }

}
