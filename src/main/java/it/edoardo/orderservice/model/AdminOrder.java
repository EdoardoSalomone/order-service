package it.edoardo.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "admin_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String adminOrderId;

    @Column(nullable = false)
    private Integer sellerId;

    private String title;

    private LocalDate openDate;
    private LocalDate closeDate;

    private Boolean isClosed;

    @OneToMany(mappedBy = "adminOrder", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AdminOrderProduct> products;
}
