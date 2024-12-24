package com.firstcomesystem.domain.orders;

import lombok.Getter;

@Getter
public class CartItemInfo {
    private final Long id;
    private final Long productId;
    private final String productName;
    private final Integer quantity;
    private final Integer price;

    private CartItemInfo(Long id, Long productId, String productName, Integer quantity, Integer price) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public static CartItemInfo toCartItemInfo(CartItem cartItem) {
        return new CartItemInfo(
                cartItem.getId(),
                cartItem.getProduct().getId(),
                cartItem.getProduct().getName(),
                cartItem.getQuantity(),
                cartItem.getProduct().getPrice()
        );
    }
}
