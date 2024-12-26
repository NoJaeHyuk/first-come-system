package com.firstcomesystem.infrastructure.order;

import com.firstcomesystem.domain.orders.OrderItem;
import com.firstcomesystem.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
