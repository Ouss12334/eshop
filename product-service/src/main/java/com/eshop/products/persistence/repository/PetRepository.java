package com.eshop.products.persistence.repository;

import com.eshop.products.persistence.model.BeautyProduct;
import com.eshop.products.persistence.model.PetProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * separate repository for beauty products.
 */
public interface PetRepository extends JpaRepository<PetProduct, String> {

    /**
     * find by subtype
     */
    List<PetProduct> findAllBySubType(String subType);
}
