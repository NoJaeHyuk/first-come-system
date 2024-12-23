package com.firstcomesystem.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    // 1. 상품의 조회
    // 2. 상품의 등록
    // 3. 상품의 상세정보

    Page<ProductInfo> getProductInfos(Pageable pageable);

    ProductInfo getProductInfo(Long productId);

    ProductInfo registerUser(ProductCommend commend);
}
