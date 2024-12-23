package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductReader;
import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.repository.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final UserReader userReader;
    private final ProductReader productReader;
    private final CartReader cartReader;
    private final CartStore cartStore;

    @Override
    public CartInfo registerCart(Long userId, CartItemCommend commend) {
        Users user = userReader.gerUser(userId);

        Cart cart = cartReader.findByUserAndActive(user, Cart.Status.ACTIVE)
                .orElseGet(() -> cartStore.save(Cart.createCart(user)));

        Product product = productReader.getProduct(commend.getProductId());

        cart.addItem(commend.toCartItem(product));
        return new CartInfo(cart);
    }
}
