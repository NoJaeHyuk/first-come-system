package com.firstcomesystem.domain.orders;

public interface OrderStore {
    Orders save(Orders order);
    OrderItem save(OrderItem orderItem);
}
