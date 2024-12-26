package com.firstcomesystem.infrastructure.order;

import com.firstcomesystem.domain.orders.Cart;
import com.firstcomesystem.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserAndStatus(Users user, Cart.Status status);
}
