package com.eshop.products.persistence.service;

import com.eshop.products.persistence.model.Product;

import java.util.List;

public interface ProductDbService {

    /**
     * get products by data_type (food, health, etc..) and its subtype (fresh food, sealed, frozen, etc..)
     */
    List<? extends Product> getProductsByType(Class<? extends Product> productType, String subType);
}
