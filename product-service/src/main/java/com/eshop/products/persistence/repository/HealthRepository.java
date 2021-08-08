package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.FoodProduct;
import com.eshop.products.persistence.model.HealthAndVitaminsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * separate repository for health products.
 */
public interface HealthRepository extends JpaRepository<HealthAndVitaminsProduct, String> {
    /**
     * find by subtype
     */
    List<FoodProduct> findAllBySubType(String subType);
}
