package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.users.entity.Users;

import java.util.Optional;

public interface CartReader {
    Optional<Cart> findByUserAndActive(Users user, Cart.Status active);

    Cart getByUserAndActive(Users user, Cart.Status active);
}
