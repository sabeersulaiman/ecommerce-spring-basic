package com.omnicuris.ecommercebasic.controllers;

import com.omnicuris.ecommercebasic.models.Order;
import com.omnicuris.ecommercebasic.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Page<Order> getOrders(@RequestParam(value = "page", required = false) int page,
                                 @RequestParam(value = "count", required = false) int count) {
        // count is constrained into [1, 100] - else defaults to 10
        if(count > 100 || count <= 0) count = 10;
        if(page < 0) page = 0;

        return orderService.getOrders(page, count);
    }

    @GetMapping("{id}")
    public Order getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }
}
