package com.firstcomesystem.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductReader {
    Product getProduct(Long id);

    Page<Product> findAll(Pageable pageable);
}
