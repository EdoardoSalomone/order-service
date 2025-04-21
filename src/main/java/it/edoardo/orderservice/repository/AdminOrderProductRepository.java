package it.edoardo.orderservice.repository;

import it.edoardo.orderservice.model.AdminOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminOrderProductRepository extends JpaRepository<AdminOrderProduct,Integer> {

    List<AdminOrderProduct> findByAdminOrder_AdminOrderId(String adminOrderId);

}
