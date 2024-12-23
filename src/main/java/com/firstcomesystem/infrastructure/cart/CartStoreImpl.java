package com.firstcomesystem.infrastructure.cart;

import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.CartStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartStoreImpl implements CartStore {

    private final CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
