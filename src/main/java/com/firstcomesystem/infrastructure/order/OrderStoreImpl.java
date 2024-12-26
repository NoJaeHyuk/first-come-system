package com.firstcomesystem.infrastructure.order;

import com.firstcomesystem.domain.orders.OrderItem;
import com.firstcomesystem.domain.orders.OrderStore;
import com.firstcomesystem.domain.orders.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Orders save(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
