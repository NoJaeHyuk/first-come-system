package com.firstcomesystem.domain.orders;

import java.util.List;

public interface CartService {
    // 1. 찜하기
    // 2. 찜내역 조회
    // 3. 수량 변경(증감)
    // 4. 항목 삭제
    // 3, 4번 쿠팡기능참조
    CartInfo registerCart(Long userId, CartItemCommend commend);

    List<CartItemInfo> getActiveCartItems(Long userId);
}

