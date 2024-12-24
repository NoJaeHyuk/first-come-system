package com.firstcomesystem.infrastructure.cart;

import com.firstcomesystem.common.exception.EntityNotFoundException;
import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.orders.CartReader;
import com.firstcomesystem.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartReaderImpl implements CartReader {

    private final CartRepository cartRepository;

    @Override
    public Optional<Cart> findByUserAndActive(Users user, Cart.Status active) {
        return cartRepository.findByUserAndStatus(user, active);
    }

    @Override
    public Cart getByUserAndActive(Users user, Cart.Status active) {
        return cartRepository.findByUserAndStatus(user, active)
                .orElseThrow(() -> new EntityNotFoundException("활성화된 장바구니가 존재하지 않습니다."));
    }
}
