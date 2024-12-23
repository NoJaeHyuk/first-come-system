package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CartItemCommend {
    private Long productId;
    private Integer quantity;

    @Builder
    private CartItemCommend(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItem toCartItem(Product product) {
        return CartItem.builder()
                .product(product)
                .quantity(quantity)
                .build();
    }
}
