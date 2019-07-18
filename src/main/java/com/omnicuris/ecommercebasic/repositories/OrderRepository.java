package com.omnicuris.ecommercebasic.repositories;

import com.omnicuris.ecommercebasic.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
