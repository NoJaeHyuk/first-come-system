package com.firstcomesystem.infrastructure.order;

import com.firstcomesystem.common.exception.EntityNotFoundException;
import com.firstcomesystem.domain.orders.OrderReader;
import com.firstcomesystem.domain.orders.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader {

    private final OrderRepository orderRepository;

    @Override
    public Orders getById(Long id) {
        return orderRepository.findById(id).orElseThrow
                (() -> new EntityNotFoundException("해당 주문을 찾을수 없습니다."));
    }
}
