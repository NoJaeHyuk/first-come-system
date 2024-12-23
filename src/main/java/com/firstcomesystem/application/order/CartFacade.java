package com.firstcomesystem.application.order;

import com.firstcomesystem.domain.orders.CartInfo;
import com.firstcomesystem.domain.orders.CartItemCommend;
import com.firstcomesystem.domain.orders.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartFacade {

    private final CartService cartService;

    public CartInfo registerCart(Long userId, CartItemCommend commend) {
        CartInfo cartInfo = cartService.registerCart(userId, commend);
        return cartInfo;
    }
}
