package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.BeautyProduct;
import com.eshop.products.persistence.model.HealthAndVitaminsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * separate repository for health products.
 */
public interface HealthRepository extends JpaRepository<HealthAndVitaminsProduct, String> {
}
