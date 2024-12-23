package com.firstcomesystem.domain.product;

public interface ProductService {
    // 1. 상품의 조회
    // 2. 상품의 등록
    // 3. 상품의 상세정보

    void getProductInfos();

    ProductInfo getProductInfo(Long productId);

    ProductInfo registerUser(ProductCommend commend);
}
