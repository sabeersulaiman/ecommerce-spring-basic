package com.omnicuris.ecommercebasic.services;

import com.omnicuris.ecommercebasic.exceptions.BadRequestException;
import com.omnicuris.ecommercebasic.exceptions.ResourceNotFoundException;
import com.omnicuris.ecommercebasic.models.Item;
import com.omnicuris.ecommercebasic.models.Order;
import com.omnicuris.ecommercebasic.models.enums.OrderStatus;
import com.omnicuris.ecommercebasic.repositories.ItemRepository;
import com.omnicuris.ecommercebasic.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        if(order.getOrderItem() == null) {
            throw new BadRequestException("Order", "orderItem", order.getOrderItem());
        }

        if(order.getQuantity() <= 0) {
            throw new BadRequestException("Order", "quantity", order.getQuantity());
        }

        Item item = itemRepository.findById(order.getOrderItem().getItemId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Item", "itemId", order.getOrderItem().getItemId())
                );

        item.setStock(item.getStock() - order.getQuantity());
        if(item.getStock() < 0) {
            throw new BadRequestException("Order", "orderItem.stock", item.getStock());
        }

        order.setStatus(OrderStatus.NEW);
        order.setOrderDate(new Date());
        order.setOrderItem(item);
        order.setTotalCost(BigDecimal.valueOf(order.getQuantity()).multiply(item.getCost()));

        itemRepository.save(item);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order", "orderId", id)
        );
    }

    @Override
    public Page<Order> getOrders(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        return orderRepository.findAll(pageable);
    }
}
