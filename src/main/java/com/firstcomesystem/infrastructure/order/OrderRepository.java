package com.firstcomesystem.infrastructure.order;

import com.firstcomesystem.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
