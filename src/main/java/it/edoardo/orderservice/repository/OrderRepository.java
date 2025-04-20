package it.edoardo.orderservice.repository;

import it.edoardo.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String>{


}
