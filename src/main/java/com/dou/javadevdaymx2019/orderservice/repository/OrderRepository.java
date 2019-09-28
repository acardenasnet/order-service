package com.dou.javadevdaymx2019.orderservice.repository;

import com.dou.javadevdaymx2019.orderservice.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
