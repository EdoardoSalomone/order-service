package it.edoardo.orderservice.repository;

import it.edoardo.orderservice.model.AdminOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminOrderRepository extends JpaRepository<AdminOrder,String> {

    List<AdminOrder> findBySellerId(Integer sellerId);

    List<AdminOrder> findByIsClosedFalse();

    List<AdminOrder> findByIsClosedTrue();
}
