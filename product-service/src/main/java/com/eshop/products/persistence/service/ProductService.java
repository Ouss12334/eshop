package com.eshop.products.persistence.service;

import com.eshop.products.persistence.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductsByType(Class<? extends Product> productType, String subType);
}
