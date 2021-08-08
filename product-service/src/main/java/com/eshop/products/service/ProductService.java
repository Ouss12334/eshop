package com.eshop.products.service;

import com.eshop.products.persistence.model.Product;

import java.util.List;

public interface ProductService {

    List<com.eshop.products.model.Product> getProductsByType(String subType);
}
