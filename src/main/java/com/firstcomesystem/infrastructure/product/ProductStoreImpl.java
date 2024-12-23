package com.firstcomesystem.infrastructure.product;

import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStoreImpl implements ProductStore {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
