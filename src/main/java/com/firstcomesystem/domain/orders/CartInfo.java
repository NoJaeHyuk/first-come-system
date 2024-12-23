package com.firstcomesystem.domain.orders;

import lombok.Getter;

@Getter
public class CartInfo {

    private final Long id;
    private final Cart.Status status;

    public CartInfo(Cart cart) {
        this.id = cart.getId();
        this.status = cart.getStatus();
    }
}
