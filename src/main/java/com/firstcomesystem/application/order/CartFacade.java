package com.firstcomesystem.application.order;

import com.firstcomesystem.domain.orders.CartInfo;
import com.firstcomesystem.domain.orders.CartItemCommend;
import com.firstcomesystem.domain.orders.CartItemInfo;
import com.firstcomesystem.domain.orders.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartFacade {

    private final CartService cartService;

    public CartInfo registerCart(Long userId, CartItemCommend commend) {
        CartInfo cartInfo = cartService.registerCart(userId, commend);
        return cartInfo;
    }


    public List<CartItemInfo> getActiveCartItems(Long userId) {
        return cartService.getActiveCartItems(userId);
    }


    public void updateCartItemQuantity(Long userId, Long cartItemId, Integer quantity) {
        cartService.updateCartItemQuantity(userId, cartItemId, quantity);
    }

    public void removeCartItems(Long cartId, List<Long> itemIds) {
        cartService.removeCartItems(cartId, itemIds);
    }
}
