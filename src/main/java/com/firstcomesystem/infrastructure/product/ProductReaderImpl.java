package com.firstcomesystem.infrastructure.product;

import com.firstcomesystem.common.exception.EntityNotFoundException;
import com.firstcomesystem.domain.product.Product;
import com.firstcomesystem.domain.product.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {
    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 제품을 찾을 수 없습니다."));
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
