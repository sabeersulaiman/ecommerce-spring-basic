package com.omnicuris.ecommercebasic.services;

import com.omnicuris.ecommercebasic.models.Order;
import org.springframework.data.domain.Page;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrder(int id);

    Page<Order> getOrders(int page, int count);
}
