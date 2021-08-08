package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.BeautyProduct;
import com.eshop.products.persistence.model.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * separate repository for beauty products.
 */
public interface BeautyRepository extends JpaRepository<BeautyProduct, String> {

    /**
     * find by subtype
     */
    List<FoodProduct> findAllBySubType(String subType);
}
