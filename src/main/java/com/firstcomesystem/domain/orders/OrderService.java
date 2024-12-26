package com.firstcomesystem.domain.orders;

import java.util.List;

public interface OrderService {
    // 1. 상품주문
    // 2. 상품취소
    // 3. 상품반품
    // 4. 상품조회

   Long registerOrder(OrderCommend.RegisterOrder commend, Long userId);
}
