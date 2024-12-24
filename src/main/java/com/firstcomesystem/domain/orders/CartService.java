package com.firstcomesystem.domain.orders;

import java.util.List;

public interface CartService {
    CartInfo registerCart(Long userId, CartItemCommend commend);

    List<CartItemInfo> getActiveCartItems(Long userId);

    void updateCartItemQuantity(Long userId, Long cartItemId, Integer quantity);

    void removeCartItems(Long cartId, List<Long> itemIds);
}

