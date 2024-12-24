package com.firstcomesystem.domain.orders;

import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductReader;
import com.firstcomesystem.domain.users.entity.Users;
import com.firstcomesystem.domain.users.repository.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final UserReader userReader;
    private final ProductReader productReader;
    private final CartReader cartReader;
    private final CartStore cartStore;

    @Override
    @Transactional
    public CartInfo registerCart(Long userId, CartItemCommend commend) {
        Users user = userReader.gerUser(userId);

        Cart cart = cartReader.findByUserAndActive(user, Cart.Status.ACTIVE)
                .orElseGet(() -> cartStore.save(Cart.createCart(user)));

        Product product = productReader.getProduct(commend.getProductId());

        cart.addItem(commend.toCartItem(product));
        return new CartInfo(cart);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartItemInfo> getActiveCartItems(Long userId) {
        Users user = userReader.gerUser(userId);
        Cart cart = cartReader.getByUserAndActive(user, Cart.Status.ACTIVE);
        return cart.getCartItems().stream()
                .map(CartItemInfo::toCartItemInfo)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateCartItemQuantity(Long userId, Long cartItemId, Integer quantity) {
        Users user = userReader.gerUser(userId);
        Cart cart = cartReader.getByUserAndActive(user, Cart.Status.ACTIVE);
        cart.changeCartItemQuantity(cartItemId, quantity);
    }
}
