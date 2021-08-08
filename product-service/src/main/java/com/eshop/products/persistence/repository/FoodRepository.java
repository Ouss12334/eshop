package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * separate repo for each product type, this one is for food.
 * https://stackoverflow.com/questions/56189962/query-the-database-using-discriminator-values
 */
public interface FoodRepository extends JpaRepository<FoodProduct, String> {
}
