package com.firstcomesystem.infrastructure.product;

import com.firstcomesystem.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
