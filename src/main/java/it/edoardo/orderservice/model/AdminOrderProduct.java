package it.edoardo.orderservice.model;

import it.edoardo.orderservice.enumeration.UnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_order_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;

    private String productName;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    private Double unitPrice;

    private Integer availableQuantity;

    @ManyToOne
    @JoinColumn(name = "admin_order_id")
    private AdminOrder adminOrder;
}
