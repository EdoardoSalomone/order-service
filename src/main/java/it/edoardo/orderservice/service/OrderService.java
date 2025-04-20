package it.edoardo.orderservice.service;

import it.edoardo.orderservice.dto.GenericResponse;
import it.edoardo.orderservice.dto.OrderRequestDTO;
import it.edoardo.orderservice.model.Order;
import it.edoardo.orderservice.model.OrderItem;
import it.edoardo.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public GenericResponse createOrder(OrderRequestDTO orderRequest) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setCustomerName(orderRequest.getCustomerName());

        List<OrderItem> items = orderRequest.getItems().stream()
                .map(dto -> {
                    OrderItem item = new OrderItem();
                    item.setProductId(dto.getProductId());
                    item.setProductName(dto.getProductName());
                    item.setQuantity(dto.getQuantity());
                    item.setOrder(order);
                    return item;
                })
                .collect(Collectors.toList());

        order.setItems(items);
        orderRepository.save(order);

        return new GenericResponse("SUCCESS", "Ordine salvato con ID: " + order.getOrderId());
    }
}
