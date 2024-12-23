package com.firstcomesystem.infrastructure.cart;

import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.CartReader;
import com.firstcomesystem.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartReaderImpl implements CartReader {

    private final CartRepository cartRepository;

    @Override
    public Optional<Cart> findByUserAndActive(Users user, Cart.Status active) {
        return cartRepository.findByUserAndStatus(user, active);
    }
}
