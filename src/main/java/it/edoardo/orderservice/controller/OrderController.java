package it.edoardo.orderservice.controller;

import it.edoardo.orderservice.dto.GenericResponse;
import it.edoardo.orderservice.dto.OrderRequestDTO;
import it.edoardo.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<GenericResponse> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        GenericResponse response = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(response);
    }
}
