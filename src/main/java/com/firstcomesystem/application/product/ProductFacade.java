package com.firstcomesystem.application.product;

import com.firstcomesystem.domain.product.ProductCommend;
import com.firstcomesystem.domain.product.ProductInfo;
import com.firstcomesystem.domain.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    public ProductInfo registerProduct(ProductCommend commend) {
        return productService.registerUser(commend);
    }

    public ProductInfo getProduct(Long productId) {
        return productService.getProductInfo(productId);
    }

    public Page<ProductInfo> getProductInfos(Pageable pageable) {
        Page<ProductInfo> products = productService.getProductInfos(pageable);
        return products;
    }
}
