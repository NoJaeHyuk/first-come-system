package com.firstcomesystem.application.order;

import com.firstcomesystem.domain.orders.OrderCommend;
import com.firstcomesystem.domain.orders.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;

    public Long registerOrder(OrderCommend.RegisterOrder commend, Long userId) {
        return orderService.registerOrder(commend, userId);
    }

    public Long cancelOrder(Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    public void returnOrder(Long orderId) {
        orderService.returnOrder(orderId);
    }
}
